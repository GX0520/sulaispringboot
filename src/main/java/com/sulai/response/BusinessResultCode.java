package com.sulai.response;

/**
 * 枚举业务常用返回码
 */
public enum BusinessResultCode implements IResultCode{

    //通用成功返回码
    SUCCESS(2000, "success"),
    //通用失败返回码
    FAILED(5000, "fail"),

    /**
     * 1开头 通用异常
     */
    //未知错误
    UNKNOWN_ERROR(10000, "unknown error"),
    //参数不合法
    INVALID_PARAM(10001,"invalid param ,check the param again"),
    //检验失败
    VALIDATE_FAILED(10002, "validate failure"),


    /**
     * 2开头 login相关
     */
    //未验证权限
    UNAUTHORIZED(20000, "user didn't login or token is out date"),
    //账号未激活
    USER_NOT_EXIST(20001,"user doesn't exist!"),
    USER_EXISTS(20002,"user already existed!"),
    //账号未激活
    ACCOUNT_UNCONFIRMED(20003,"user account was unconfirmed!"),
    //账号被禁用
    ACCOUNT_BANNED(20004,"user account was banned!"),
    //firebase 相关异常
    FIREBASE_EXCEPTION(20005, "there are something wrong when connecting to firebase..."),

    /**
     * 3开头 招聘者相关
     * @return
     */
    RECRUITER_NOT_EXISTS(30001,"recruiter doesn't exist!"),
    RECRUITER_EXISTS(30002,"recruiter already existed!"),
    //账号被禁用
    RECRUITER_BANNED(30004,"recruiter account was banned!"),
    //投递工作数量已达上限
    LIMIT_CREATE_JOB(30001,"reach the limit count of creating jobs"),
    //投递工作数量已达上限
    RECRUITER_IS_EXIT(30002,"recruiter is exit,don't repeat to create"),
    WAITING_FOR_VERIFIED(30010,"already uploaded, please wait for verifying!"),
    ALREADY_VERIFIED(30011,"already verified, don't upload document again!"),
    UN_VERIFIED_COMPANY(30012,"the company is not verified, please verify the company first!"),
    FORBIDDEN_VERIFY_RECRUITER(30013,"YOU ARE NOT ALLOWED TO UPLOAD AGAIN!PLEASE CONTACT THE MANAGER!"),
    DOCUMENT_ALREADY_REVIEWED(30014,"document was already reviewed!"),

    /**
     * 4开头 求职者相关
     * @return
     */
    CANDIDATE_NOT_EXISTS(40001,"candidate doesn't exist!"),
    CANDIDATE_EXISTS(40002,"candidate already existed!"),
    //账号被禁用
    CANDIDATE_BANNED(40004,"candidate account was banned!"),
    PREFERENCE_EXISTS(40005,"this job preference has been added!"),
    FORBIDDEN_DELETE_PREFERENCE(40006,"You can't delete this job preference details. At least one job preference details is required."),
    FORBIDDEN_DELETE_EDUCATION(40007,"You can't delete this work education details. At least one work experience details is required."),
    FORBIDDEN_DELETE_EXPERIENCE(40008,"You can't delete this work experience details. At least one work experience details is required."),
    /**
     * 5开头 工作相关
     * @return
     */


    /**
     * 6开头 公司相关
     * @return
     */
    //公司的boss数量达到上限
    LIMIT_BOSS_COUNT(60001,"reach the limit count of company bosses"),
    WAITING_FOR_VERIFIED1(60010,"already uploaded, please wait for verifying!"),
    FORBIDDEN_VERIFY_COMPANY(60011,"YOU ARE NOT ALLOWED TO UPLOAD AGAIN!PLEASE CONTACT THE MANAGER!"),

    /**
     * 7开头 聊天相关
     * @return
     */
    //发起聊天的数量达到上限
    LIMIT_INIT_CHAT_COUNT(70001,"reach the limit count of chat initiate"),

    /**
     * 8 文件处理相关
     */
    FAIL_UPLOAD_FILE(80001,"上传文件失败"),
    FORBID_UPLOADING_FILE(80002,"不允许上传文件"),
    FILE_NOT_FOUND(80003,"file not found!"),

    /**
     * 9 邮件处理相关
     */
    FAIL_SEND_MAIL(90001,"发送邮件失败！"),
    ;
            ;

    private int code;
    private String message;

    private BusinessResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    /**
     * 当不愿使用枚举中默认的message时，支持自定义提示信息
     * @param message 要设置的message
     * @return 自定义message的返回码
     */
    @Override
    public IResultCode setMessage(String message) {
        this.message = message;
        return this;
    }
}
