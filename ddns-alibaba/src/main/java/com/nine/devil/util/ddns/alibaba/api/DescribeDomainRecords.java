package com.nine.devil.util.ddns.alibaba.api;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsRequest;
import com.aliyuncs.alidns.model.v20150109.DescribeDomainRecordsResponse;
import com.aliyuncs.domain.model.v20180129.*;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.nine.devil.util.ddns.alibaba.config.DDNSAlibabaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by this on 2019-4-28 10:54
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
public class DescribeDomainRecords {

    @Autowired
    DDNSAlibabaInfo ddnsAlibabaInfo;

    public DescribeDomainRecordsResponse records(){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ddnsAlibabaInfo.getAccessKeyId(), ddnsAlibabaInfo.getAccessSecret());
        IAcsClient client = new DefaultAcsClient(profile);

        DescribeDomainRecordsRequest request = new DescribeDomainRecordsRequest();
        request.setDomainName(ddnsAlibabaInfo.getDomainName());
        try {
            return client.getAcsResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
    }
}
