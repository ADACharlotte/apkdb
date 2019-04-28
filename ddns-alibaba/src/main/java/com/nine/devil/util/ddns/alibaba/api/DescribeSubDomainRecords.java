package com.nine.devil.util.ddns.alibaba.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeSubDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeSubDomainRecordsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.nine.devil.util.ddns.alibaba.config.DDNSAlibabaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this on 2019-4-28 13:32
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
public class DescribeSubDomainRecords {

    @Autowired
    DDNSAlibabaInfo ddnsAlibabaInfo;

    public List<String> record(String subDomain) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ddnsAlibabaInfo.getAccessKeyId(), ddnsAlibabaInfo.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeSubDomainRecordsRequest request = new DescribeSubDomainRecordsRequest();
        request.setSubDomain(subDomain);

        try {
            DescribeSubDomainRecordsResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
            List<String> list=new ArrayList<>();
            list.add(response.getDomainRecords().get(0).getRecordId());
            list.add(response.getDomainRecords().get(0).getRR());
            return list;
        } catch (ServerException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }



}
