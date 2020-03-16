package com.medical.utils;


import com.medical.entity.vo.BaseResponseVo;

public class ResponseUtils {

    public static String SUCCESS_CODE = "10000";
    public static String SUCCESS_MESSAGE = "请求成功";

    public static String FAIL_CODE = "99999";
    public static String FAIL_MESSAGE = "请求失败";

    public static String ILLEGAL_PARAMS_CODE = "11000";
    public static String ILLEGAL_PARAMS_MESSAGE = "请求参数不符合要求";

    public static BaseResponseVo success(){
        return build(SUCCESS_CODE,SUCCESS_MESSAGE);
    }
    public static<T> BaseResponseVo<T> success(T data){
        BaseResponseVo<T> responseVo = success();
        responseVo.setData(data);
        return  responseVo;
    }
    public static BaseResponseVo successMsg(String message){
        return  build(SUCCESS_CODE,message);
    }
    public static BaseResponseVo fail(String msg){
        return build(FAIL_CODE,msg);
    }
    public static BaseResponseVo fail(){
        return fail(FAIL_MESSAGE);
    }
    public static BaseResponseVo illegalParams(){
        return build(ILLEGAL_PARAMS_CODE,ILLEGAL_PARAMS_MESSAGE);

    }
    public static BaseResponseVo build(String code,String message){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        baseResponseVo.setCode(code);
        baseResponseVo.setMessage(message);
        return baseResponseVo;
    }

    public static<T> BaseResponseVo<T> build(String code,String message,T data){
        BaseResponseVo baseResponseVo = new BaseResponseVo();
        baseResponseVo.setCode(code);
        baseResponseVo.setMessage(message);
        baseResponseVo.setData(data);
        return baseResponseVo;
    }

    public static<T> BaseResponseVo<T> fail(String msg,T data){
        return build(FAIL_CODE,msg,data);
    }


}
