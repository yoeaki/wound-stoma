package com.linkgoo.framework.web.entity.pat;

import lombok.Data;

@Data
public class ReservationVO {

    /** pk，逗号分隔 */
    private String pks;

    /** id */
    private Long id;
    /** 用户id */
    private Long patientId;
    /** 医生id */
    private Long doctorId;
    /** 预约时间 */
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date reservationTime;
    /** 备注信息 */
    private String remarks;
    /** 预约进度 */
    private String schedule;

    private String  patientName;

    private String doctorName;
}
