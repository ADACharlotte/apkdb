package com.nine.devil.util.ddns.alibaba.runner;

import com.nine.devil.util.ddns.alibaba.api.DescribeSubDomainRecords;
import com.nine.devil.util.ddns.alibaba.api.UpdateDomainRecord;
import com.nine.devil.util.ddns.alibaba.config.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by this on 2019-4-28 15:12
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
@Order(2)
public class OnStartTask implements ApplicationRunner {

    @Autowired
    Records records;

    @Autowired
    DescribeSubDomainRecords describeSubDomainRecords;

    @Autowired
    UpdateDomainRecord updateDomainRecord;

    @Scheduled(cron = "0 0 0/1 * * ? *")
    public void task(){
        for (Records.Record record: records.getRecord()) {
            List<String> list=describeSubDomainRecords.record(record.getDomainName());
            updateDomainRecord.update(list.get(0),list.get(1),record.getType());
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        task();
    }
}
