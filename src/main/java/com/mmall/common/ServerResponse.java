package com.mmall.common;/**
 * Created by Administrator on 2018/11/25.
 */

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @program: mmall
 * @description: 服务响应对象
 * @author: peipeizx
 * @create: 2018-11-25-12-11
 **/
// 保证序列化json如果是null,key会消失
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status, String msg){
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    // 保证isSuccess不在序列化中
    @JsonIgnore
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.Error.getCode(),ResponseCode.Error.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errorMess){
        return new ServerResponse<T>(ResponseCode.Error.getCode(), errorMess);
    }
    public static <T> ServerResponse<T> createByCodeErrorMessage(int errCode, String errMess){
        return new ServerResponse<T>(errCode, errMess);
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
