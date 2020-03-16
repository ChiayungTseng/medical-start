package com.medical.entity.vo;

import lombok.Data;

@Data
public class BaseResponseVo<T> {

    private String code;

    private String message;

    private T data;


}
