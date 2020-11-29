package com.sulai.response;

public interface IResultCode {

    int getCode();

    String getMessage();

    /**
     * 支持自定义设置提示信息message
     * @param message
     * @return IResultCode
     */
    IResultCode setMessage(String message);
}
