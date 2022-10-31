package com.example.ncovback.controller;

import com.example.ncovback.common.R;
import com.example.ncovback.entity.Sms;
import com.example.ncovback.service.HWSMSService;
import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.GlobalCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.iam.v3.IamClient;
import com.huaweicloud.sdk.iam.v3.model.*;
import com.huaweicloud.sdk.iam.v3.region.IamRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class HWSMSController {
    @Autowired
    private HWSMSService hwsmsService;
    @PostMapping("/getToken")
    public static void getToken() {
        String ak = "XLAEI6LJ84URAVLWXY2U";
        String sk = "3DcydvQUwdjlMbd26O2Ko8Ea5GrmSMZrZ0B6PMhS";

        ICredential auth = new GlobalCredentials()
                .withAk(ak)
                .withSk(sk);

        IamClient client = IamClient.newBuilder()
                .withCredential(auth)
                .withRegion(IamRegion.valueOf("cn-east-3"))
                .build();
        KeystoneCreateUserTokenByPasswordRequest request = new KeystoneCreateUserTokenByPasswordRequest();
        KeystoneCreateUserTokenByPasswordRequestBody body = new KeystoneCreateUserTokenByPasswordRequestBody();
        AuthScopeDomain domainScope = new AuthScopeDomain();
        domainScope.withId("5d4c79f5ed274405bfec714be59dcf75");
        AuthScope scopeAuth = new AuthScope();
        scopeAuth.withDomain(domainScope);
        PwdPasswordUserDomain domainUser = new PwdPasswordUserDomain();
        domainUser.withName("xkj20001214");
        PwdPasswordUser userPassword = new PwdPasswordUser();
        userPassword.withDomain(domainUser)
                .withName("IAMxkj")
                .withPassword("XKJ001214.");
        PwdPassword passwordIdentity = new PwdPassword();
        passwordIdentity.withUser(userPassword);
        List<PwdIdentity.MethodsEnum> listIdentityMethods = new ArrayList<>();
        listIdentityMethods.add(PwdIdentity.MethodsEnum.fromValue("password"));
        PwdIdentity identityAuth = new PwdIdentity();
        identityAuth.withMethods(listIdentityMethods)
                .withPassword(passwordIdentity);
        PwdAuth authbody = new PwdAuth();
        authbody.withIdentity(identityAuth)
                .withScope(scopeAuth);
        body.withAuth(authbody);
        request.withBody(body);
        try {
            KeystoneCreateUserTokenByPasswordResponse response = client.keystoneCreateUserTokenByPassword(request);
            System.out.println(response.getXSubjectToken());
        } catch (ConnectionException | ServiceResponseException | RequestTimeoutException e) {
            e.printStackTrace();
        }
    }
    @PostMapping("/getSMN")
    public R getSMN(@RequestBody Sms sms) {
        String code= hwsmsService.getSMN(sms);
        R r=new R();
        r.setCode(200);
        r.setMsg("LoginSuccess");
        r.setData(code);
        return r;
    }

}

