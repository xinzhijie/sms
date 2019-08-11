package com.cnpc.sms.domain;

import lombok.Data;

import java.util.List;

@Data
public class Sms {
    private List<String> phoneNumber;
    private String type;
    private MsgParam msgParam;
}
