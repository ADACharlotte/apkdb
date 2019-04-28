package com.nine.devil.util.ddns.alibaba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by this on 2019-4-28 13:38
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
@RefreshScope
public class DDNSAlibabaInfo {

    @Value("${ddns.alibaba.accessKeyId}")
    private String accessKeyId;
    @Value("${ddns.alibaba.accessSecret}")
    private String accessSecret;
    @Value("${ddns.alibaba.domainName}")
    private String domainName;

    private String ip;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
