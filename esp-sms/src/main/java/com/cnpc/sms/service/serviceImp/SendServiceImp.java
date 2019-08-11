package com.cnpc.sms.service.serviceImp;

import com.cnpc.sms.config.NetAddress;
import com.cnpc.sms.domain.Sms;
import com.cnpc.sms.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@Slf4j
@Service
public class SendServiceImp implements SendService {
    @Override
    public void sendSms(WebClient webClient, NetAddress netAddress, List<String> list, Sms sms) {
        Sms temp = new Sms();
        BeanUtils.copyProperties(sms, temp);
        temp.setPhoneNumber(list);
        Mono<String> resp = webClient
                .post().uri(netAddress.getUri())
                .header("token", netAddress.getToken())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(temp), Sms.class)
                .retrieve()
                .bodyToMono(String.class);
        resp.subscribe((str) -> {
            log.info("发送短信：{}", str);
        });
    }
}
