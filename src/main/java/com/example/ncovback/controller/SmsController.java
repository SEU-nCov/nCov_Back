package com.example.ncovback.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.ncovback.common.R;
import com.example.ncovback.entity.Sms;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class SmsController {
    private static final String SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //private static final String APP_KEY="39a9e0d85b19883cdf09ecda1abe8bb9";//网易云信分配的账号 48bdec2766d07fd9194ff46dcad6a4e6
    private static final String APP_KEY="48bdec2766d07fd9194ff46dcad6a4e6";
    //private static final String APP_SECRET="d40dc8ce5fd8";//网易云信分配的密钥 a920c9787a82
    private static final String APP_SECRET="a920c9787a82";
    private static final String MOULD_ID="19500664";//模板ID
    private static final String NONCE="123456";//随机数
    private static final String CODELEN = "6";

    public static class CheckSumBuilder {

        //计算并获取checkSum
        public static String getCheckSum(String appSecret,String nonce,String curTime){
            return encode("sha1",appSecret + nonce + curTime);
        }

        //计算并获取md5
        public static String getMD5(String requestBody){
            return encode("md5",requestBody);
        }

        private static String encode(String algorithm, String value) {
            if (value == null) {
                return null;
            }
            try {
                MessageDigest messageDigest
                        = MessageDigest.getInstance(algorithm);
                messageDigest.update(value.getBytes());
                return getFormattedText(messageDigest.digest());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        private static String getFormattedText(byte[] bytes) {
            int len = bytes.length;
            StringBuilder buf = new StringBuilder(len * 2);
            for (int j = 0; j < len; j++) {
                buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
                buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
            }
            return buf.toString();
        }
        private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5',
                '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    }
    @PostMapping("/sendSMS")
    public static R send(@RequestBody Sms sms) throws Exception {
        R r =new R();
        String phone=sms.getPhone();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(SERVER_URL);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
        httpPost.addHeader("AppKey", APP_KEY);
        httpPost.addHeader("Nonce", NONCE);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        List<NameValuePair> nameValuePairs =new ArrayList<>();

        nameValuePairs.add(new BasicNameValuePair("templateid", MOULD_ID));
        nameValuePairs.add(new BasicNameValuePair("mobile", phone));
        nameValuePairs.add(new BasicNameValuePair("codeLen", CODELEN));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

        HttpResponse response = httpClient.execute(httpPost);
        String result= EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonResult = JSONObject.parseObject(result);
        r.setCode(Integer.valueOf(jsonResult.getString("code")));
        r.setMsg(jsonResult.getString("msg"));
        r.setData(jsonResult.getString("obj"));
        return r;
    }
}
