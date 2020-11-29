package com.sulai.response;


import java.io.Serializable;

public class CommonResult<T> implements Serializable{

    /**
     * result code
     * 2000 for success
     */
    private int code;

    /**
     * result message
     */
    private String message;

    /**
     * return data
     */
    private T data = EmptyObject.get();

    /**
     * extra data
     */
    private Object extra = EmptyObject.get();

    /**
     * 加上无参的构造函数
     */
    protected CommonResult() {
    }

    /**
     * <p>Constructor for CommonResult.</p>
     *
     * @param code a int.
     * @param message a {@link String} object.
     */
    protected CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * <p>Constructor for CommonResult.</p>
     *
     * @param code a int.
     * @param message a {@link String} object.
     * @param data a T object.
     */
    protected CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        setData(data);
    }

    /**
     * <p>Constructor for CommonResult.</p>
     *
     */
    protected CommonResult(IResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * <p>Constructor for CommonResult.</p>
     *
     * @param data a T object.
     */
    protected CommonResult(IResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        setData(data);
    }

    /**
     * 通用成功返回结果
     *
     * @return 无data 通用成功返回结果
     */
    public static CommonResult success() {
        return new CommonResult(BusinessResultCode.SUCCESS);
    }

    /**
     * 通用成功返回结果
     *
     * @return 无data 自定义message 通用成功返回结果
     * @param message a {@link String} object.
     */
    public static CommonResult success(String message) {
        return new CommonResult(BusinessResultCode.SUCCESS.getCode(),message);
    }

    /**
     * 通用成功返回结果
     *
     * @return 有data 通用成功返回结果
     * @param data a T object.
     * @param <T> a T object.
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(BusinessResultCode.SUCCESS,data);
    }

    /**
     * 通用成功返回结果
     *
     * @return 有data 自定义message 通用成功返回结果
     * @param message a {@link String} object.
     * @param data a T object.
     * @param <T> a T object.
     */
    public static <T> CommonResult<T> success(String message,T data) {
        return new CommonResult<T>(BusinessResultCode.SUCCESS.getCode(),message,data);
    }

    /**
     * 通用失败返回结果
     *
     * @return 无data 通用失败返回结果
     */
    public static CommonResult failed() {
        return new CommonResult(BusinessResultCode.FAILED);
    }

    /**
     * 通用失败返回结果
     *
     * @return 无data 自定义message 通用失败返回结果
     * @param message a {@link String} object.
     */
    public static CommonResult failed(String message) {
        return new CommonResult(BusinessResultCode.FAILED.getCode(),message);
    }

    /**
     * 通用失败返回结果
     *
     * @return 有数据 通用失败返回结果
     * @param data a T object.
     * @param <T> a T object.
     */
    public static <T> CommonResult<T> failed(T data) {
        return new CommonResult<T>(BusinessResultCode.FAILED,data);
    }

    /**
     * 通用失败返回结果
     *
     * @return 有数据自定义提示信息 通用失败返回结果
     * @param message a {@link String} object.
     * @param data a T object.
     * @param <T> a T object.
     */
    public static <T> CommonResult<T> failed(String message,T data) {
        return new CommonResult<T>(BusinessResultCode.FAILED.getCode(),message,data);
    }

    /**
     * 返回任意指定的返回码
     *
     * @param resultCode 返回码枚举
     * @return  无data 默认指定返回码的返回结果
     */
    public static CommonResult create(IResultCode resultCode) {
        return new CommonResult(resultCode);
    }

    /**
     * 返回任意指定的返回码
     *
     * @param resultCode 返回码枚举
     * @param message 自定义message
     * @return 无data 自定义message的指定返回码的返回结果
     */
    public static CommonResult create(IResultCode resultCode,String message) {
        return new CommonResult(resultCode.getCode(),message);
    }

    /**
     * 返回任意指定的返回码
     *
     * @param resultCode 返回码枚举
     * @param data 返回的数据
     * @param <T> data的类型
     * @return 有data 默认指定返回码的返回结果
     */
    public static <T> CommonResult<T> create(IResultCode resultCode,T data) {
        return new CommonResult<T>(resultCode,data);
    }

    /**
     * 返回任意指定的返回码
     *
     * @param resultCode 返回码枚举
     * @param message 自定义message
     * @param data 返回的数据
     * @param <T> data的类型
     * @return 有data 自定义message的指定返回码的返回结果
     */
    public static <T> CommonResult<T> create(IResultCode resultCode,String message,T data) {
        return new CommonResult<T>(resultCode.getCode(),message,data);
    }


    /**
     * <p>Getter for the field <code>code</code>.</p>
     *
     * @return a int.
     */
    public int getCode() {
        return code;
    }

    /**
     * <p>Setter for the field <code>code</code>.</p>
     *
     * @param code a int.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * <p>Getter for the field <code>message</code>.</p>
     *
     * @return a {@link String} object.
     */
    public String getMessage() {
        return message;
    }

    /**
     * <p>Setter for the field <code>message</code>.</p>
     *
     * @param message a {@link String} object.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * <p>Getter for the field <code>data</code>.</p>
     *
     * @return a T object.
     */
    public T getData() {
        return data;
    }

    /**
     * <p>Setter for the field <code>data</code>.</p>
     *
     * @param data a T object.
     */
    public void setData(T data) {
        if(data == null){
            return;
        }
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public CommonResult<T> extra(Object extra){
        this.extra = extra;
        return this;
    }
}