package com.cnpc.sms.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: limc
 */
@Data
public class MsgParam {
    private String Year;
    private String Count;
    private LocalDateTime StartTime;
    private LocalDateTime EndTime;
    private String UserName;
    private String CourseName;
    private String Text;
    private String Cause;
    private String mail;
}
