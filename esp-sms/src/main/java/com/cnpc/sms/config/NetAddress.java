package com.cnpc.sms.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "net.address")
public class NetAddress {
    private String token;
    private String ip;
    private String uri;
}
