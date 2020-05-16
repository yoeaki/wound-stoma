package com.linkgoo.framework.web.entity.cas;

import lombok.Data;

@Data
public class CaseVo {

    /** pk，逗号分隔 */
    private String pks;

    /** id */
    private Long id;
    /** 病人id */
    private Long patientId;
    /** 医生id */
    private Long doctorId;
    /** 就诊时间 */
    @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date seeTime;
    /** 病因id */
    private Long disaseId;
    /** 诊断 */
    private String diagnosis;
    /** 建议 */
    private String recommendation;
    /** 病图 */
        private String casePic;

    private String patientName;

    private String doctorName;

    private String disaseName;
}
