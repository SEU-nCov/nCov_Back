package com.example.ncovback.service;

import com.example.ncovback.entity.Message;
import com.example.ncovback.entity.Sms;
import com.example.ncovback.entity.Town;
import com.example.ncovback.entity.User;
import com.example.ncovback.mapper.HWSMSMapper;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.smn.v2.SmnClient;
import com.huaweicloud.sdk.smn.v2.model.*;
import com.huaweicloud.sdk.smn.v2.region.SmnRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HWSMSService {
    @Autowired
    private HWSMSMapper hwsmsMapper;

    public String getSMN(Sms sms) {
        String ak = "XLAEI6LJ84URAVLWXY2U";
        String sk = "3DcydvQUwdjlMbd26O2Ko8Ea5GrmSMZrZ0B6PMhS";
        String topicUrn = "urn:smn:cn-east-3:be6d59e1e3064213a420701ed6f3b876:SEUnCov";
        Integer subcount=0;
        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        SmnClient client = SmnClient.newBuilder()
                .withCredential(auth)
                .withRegion(SmnRegion.valueOf("cn-east-3"))
                .build();
        int iftopicexist = hwsmsMapper.TopicExist(sms);
        if (iftopicexist == 0) {
            CreateTopicRequest request_topic = new CreateTopicRequest();
            CreateTopicRequestBody body_topic = new CreateTopicRequestBody();
            body_topic.withDisplayName(sms.getPhone());
            body_topic.withName(sms.getPhone());
            request_topic.withBody(body_topic);
            try {
                CreateTopicResponse response = client.createTopic(request_topic);
                topicUrn = response.getTopicUrn();
                sms.setTopicurn(topicUrn);
                hwsmsMapper.InsertTopic(sms);
            } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
                e.printStackTrace();
            }

            AddSubscriptionRequest request_sub = new AddSubscriptionRequest();
            request_sub.withTopicUrn(topicUrn);
            AddSubscriptionRequestBody body_sub = new AddSubscriptionRequestBody();
            body_sub.withEndpoint(sms.getPhone());
            body_sub.withProtocol("sms");
            request_sub.withBody(body_sub);
            try {
                AddSubscriptionResponse response = client.addSubscription(request_sub);
            } catch (ConnectionException | ServiceResponseException | RequestTimeoutException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("exist");
        }
        topicUrn = hwsmsMapper.getTopicurn(sms);
        ListSubscriptionsByTopicRequest request_check = new ListSubscriptionsByTopicRequest();
        request_check.withTopicUrn(topicUrn);
        while(true) {
            try {
                ListSubscriptionsByTopicResponse response_check = client.listSubscriptionsByTopic(request_check);
                System.out.println(response_check.getSubscriptionCount());
                subcount=response_check.getSubscriptionCount();
            } catch (ConnectionException | ServiceResponseException | RequestTimeoutException e) {
                e.printStackTrace();
            }
            if(subcount==1) {
                PublishMessageRequest request = new PublishMessageRequest();
                request.withTopicUrn(topicUrn);
                PublishMessageRequestBody body = new PublishMessageRequestBody();
                Map<String, String> listbodyTags = new HashMap<>();
                int vcode = (int) ((Math.random() * 9 + 1) * 100000);
                String vscode = Integer.toString(vcode);
                listbodyTags.put("code", vscode);
                body.withTags(listbodyTags);
                body.withMessageTemplateName("vericode");
                body.withSubject("【SEU防疫宝】");
                request.withBody(body);
                try {
                    PublishMessageResponse response = client.publishMessage(request);
                    return vscode;
                } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendnatResultSMS(Message message) {
        List<String> topic_list=hwsmsMapper.getTopiclist(message);
        String ak = "XLAEI6LJ84URAVLWXY2U";
        String sk = "3DcydvQUwdjlMbd26O2Ko8Ea5GrmSMZrZ0B6PMhS";
        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        SmnClient client = SmnClient.newBuilder()
                .withCredential(auth)
                .withRegion(SmnRegion.valueOf("cn-east-3"))
                .build();
        for(String topicUrn:topic_list) {
            PublishMessageRequest request = new PublishMessageRequest();
            request.withTopicUrn(topicUrn);
            PublishMessageRequestBody body = new PublishMessageRequestBody();
            body.withMessageTemplateName("natres");
            body.withSubject("【SEU防疫宝】");
            request.withBody(body);
            try {
                PublishMessageResponse response = client.publishMessage(request);
            } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
                e.printStackTrace();
            }
        }
    }

    public void submitCovAllTest(Integer area_code, Date start_time, Date end_time, String extraInfo) {
        List<String> topic_list=hwsmsMapper.getTopiclistbyArea(area_code);
        String ak = "XLAEI6LJ84URAVLWXY2U";
        String sk = "3DcydvQUwdjlMbd26O2Ko8Ea5GrmSMZrZ0B6PMhS";
        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);

        SmnClient client = SmnClient.newBuilder()
                .withCredential(auth)
                .withRegion(SmnRegion.valueOf("cn-east-3"))
                .build();
        for(String topicUrn:topic_list) {
            PublishMessageRequest request = new PublishMessageRequest();
            request.withTopicUrn(topicUrn);
            PublishMessageRequestBody body = new PublishMessageRequestBody();
            Map<String, String> listbodyTags = new HashMap<>();
            listbodyTags.put("start_time", start_time.toString());
            listbodyTags.put("end_time",end_time.toString());
            listbodyTags.put("extraInfo",extraInfo);
            body.withTags(listbodyTags);
            body.withMessageTemplateName("AllTest");
            body.withSubject("【SEU防疫宝】");
            request.withBody(body);
            try {
                PublishMessageResponse response = client.publishMessage(request);
            } catch (ConnectionException | RequestTimeoutException | ServiceResponseException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer addCovAllTestMessage(String area_code) {
        List<Integer> user_list=hwsmsMapper.getUserListbyarea(area_code);
        for(Integer user_id:user_list){
            hwsmsMapper.addCovAllTestMessage(user_id);
        }
        return 1;
    }
}
