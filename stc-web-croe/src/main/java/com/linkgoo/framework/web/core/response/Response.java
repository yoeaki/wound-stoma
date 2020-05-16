package com.linkgoo.framework.web.core.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<DATA> {

    private int status;
    private String msg;
    private DATA data;

}
