package com.linkgoo.framework.web.core.constant;

public interface SysConstant {




    interface Success{

        //成功
        String yes = "1";

        //失败
        String no = "0";

    }

    interface Param{
        String regRole = "regRole";
        String sysSetting = "sysSetting";
        String regExamine = "regExamine";
        String administrator = "administrator";
        String notice = "notice";
        String power = "power";
    }

    interface MsgAndEventType{
        String notice = "公告";
        String collec = "收集";
        String follow = "关注";
        String sign = "标记";
        String collecPush = "收集事件推送";
        String followPush = "关注事件推送";
        String signPush = "标记事件推送";

    }

}
