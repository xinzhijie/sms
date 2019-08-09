package com.cnpc.sms.domain;

import lombok.Data;

import java.util.List;

@Data
public class Sms {
    private List<String> PhoneNumber;
    private String type;
    private T t;
}
