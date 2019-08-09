package com.cnpc.sms.constant;


import com.cnpc.sms.domain.model.ISmsMessage;

public enum SmsMessage {
    /**
     *  发送短信接口
     */
    JZXKJS("",""),
    PXBX("", "");

    private String code;
    private String desc;
    private ISmsMessage smsMessage;

    SmsMessage(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


}
