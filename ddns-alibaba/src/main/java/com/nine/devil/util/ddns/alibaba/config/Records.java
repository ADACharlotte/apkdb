package com.nine.devil.util.ddns.alibaba.config;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by this on 2019-4-28 13:53
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
@ConfigurationProperties("records")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Records {

    private List<Record> record;

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public static class Record{
        private String domainName;
        private String type;

        public String getDomainName() {
            return domainName;
        }

        public void setDomainName(String domainName) {
            this.domainName = domainName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
