package com.mizuki.sinatv.config;

/**
 * date: Created xiaoyuan on 16/11/05.
 */
public class UrlConfig {

    public static String TestHostUrl;

    // 0测试环境
    public static final int Test = 0;
    // 1线上环境
    public static final int Online = 1;

    static {
        switch (Online) {
            case Test:
                TestHostUrl = "http://121.42.26.175:14444/";
                break;
            case Online:
                TestHostUrl = "http://121.42.26.175:14444/";
                break;
        }
    }


    public final static String API_V1_0_TEST = "contact/company/list.json";//测试用
    public final static String API_FILE_UPLOAD = "util/file/upload.json";//##图片上传
    public final static String API_USER_SIGN_UP = "live/register.json";//##注册接口
    public final static String API_USER_SIGN_IN = "live/login.json";//##登录接口
    public final static String API_USER_USERINFO= "live/my_info.json";//##信息接口


}