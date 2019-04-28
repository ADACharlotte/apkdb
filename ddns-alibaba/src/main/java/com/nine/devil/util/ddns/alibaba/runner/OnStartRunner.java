package com.nine.devil.util.ddns.alibaba.runner;

import com.nine.devil.util.ddns.alibaba.config.DDNSAlibabaInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by this on 2019-4-28 15:14
 *
 * @author Mr.Wang
 * @version 1.0
 * @email 17602184237@163.com
 * @since 1.0
 */
@Component
@Order(1)
public class OnStartRunner implements ApplicationRunner {

    @Autowired
    DDNSAlibabaInfo ddnsAlibabaInfo;

    @Value("${ip.url}")
    private String url;

    protected void getIP() {
        try {
            Document document = Jsoup.connect(url).get();
            Elements center = document.select("center");
            String content = center.text();
            String ip = content.substring(content.indexOf("[") + 1, content.indexOf("]"));
            ddnsAlibabaInfo.setIp(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        getIP();
    }

}
