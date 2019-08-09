package com.cnpc.sms.controller;

import com.cnpc.sms.config.NetAddress;
import com.cnpc.sms.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: limc
 */
@RestController
public class SendController {

    @Autowired
    private NetAddress netAddress;

    @PostMapping("sendPost")
    public String post() {
        String s = HttpUtil.sendPost("http://" + netAddress.getIp() + netAddress.getUri(),
                "{'PhoneNumber':'13264088053','Type':'1'}");
        return s;
    }
}
