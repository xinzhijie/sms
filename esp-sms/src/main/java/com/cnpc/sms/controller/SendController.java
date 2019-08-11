package com.cnpc.sms.controller;

import com.cnpc.sms.config.NetAddress;
import com.cnpc.sms.domain.Sms;
import com.cnpc.sms.service.SendService;
import com.cnpc.sms.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: limc
 */
@RestController
public class SendController {

    @Autowired
    private NetAddress netAddress;

    @Autowired
    private SendService sendService;

    @PostMapping("sendSms")
    public String sendSms(@RequestBody Sms sms) {
        if (sms.getPhoneNumber() == null || sms.getPhoneNumber().size() == 0) {
            return "没有传递用户手机号码";
        }
        WebClient webClient = WebClient.create(netAddress.getIp());
        List<List<String>> listGroup = getListGroup(sms.getPhoneNumber());
        listGroup.stream().forEach((item) -> {
            sendService.sendSms(webClient, netAddress, item, sms);
        });
        return "success";
    }

    private List<List<String>> getListGroup(List<String> list) {
        List<List<String>> listGroup = new ArrayList<List<String>>();
        int listSize = list.size();
        int toIndex = 2;
        for (int i = 0; i < listSize; i += toIndex) {
            if (i + toIndex > listSize) {
                toIndex = listSize - i;
            }
            List<String> newList = list.subList(i, i + toIndex);
            listGroup.add(newList);
        }
        return listGroup;
    }
}
