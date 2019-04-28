package com.nine.devil.util.ddns.alibaba.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.nine.devil.util.ddns.alibaba.config.DDNSAlibabaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by this on 2019-4-28 10:55
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
public class UpdateDomainRecord {

    @Autowired
    DDNSAlibabaInfo ddnsAlibabaInfo;

    public void update(String recordId,String RR,String type){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ddnsAlibabaInfo.getAccessKeyId(), ddnsAlibabaInfo.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        UpdateDomainRecordRequest request = new UpdateDomainRecordRequest();
        request.setValue(ddnsAlibabaInfo.getIp());
        request.setType(type);
        request.setRR(RR);
        request.setRecordId(recordId);

        try {
            UpdateDomainRecordResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }

}
