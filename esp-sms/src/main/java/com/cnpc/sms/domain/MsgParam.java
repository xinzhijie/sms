package com.cnpc.sms.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: limc
 */
@Data
public class MsgParam {
    private String year;
    private String count;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String userName;
    private String courseName;
    private String text;
    private String cause;
    private String mail;
}
