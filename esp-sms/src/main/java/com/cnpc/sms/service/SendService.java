package com.cnpc.sms.service;

import com.cnpc.sms.config.NetAddress;
import com.cnpc.sms.domain.Sms;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public interface SendService {
    void sendSms(WebClient webClient, NetAddress netAddress, List<String> list, Sms sms);
}
