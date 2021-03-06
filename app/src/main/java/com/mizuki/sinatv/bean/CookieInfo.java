package com.mizuki.sinatv.bean;


import com.mizuki.sinatv.app.YuYouBangApp;
import com.mizuki.sinatv.utils.VersionUtils;

public class CookieInfo {

    public CookieInfo(String cookie_id, String first_time, String hmsr, String site) {
        this.cookie_id = cookie_id;
        this.first_time = first_time;
        this.hmsr = hmsr;
        this.site = site;
    }

    private String cookie_id;
    private String first_time;
    private String hmsr;
    private String site;
    private int versionCode = VersionUtils.getVersionCode(YuYouBangApp.getContext());

    public String getCookie_id() {
        return cookie_id;
    }

    public void setCookie_id(String cookie_id) {
        this.cookie_id = cookie_id;
    }

    public String getFirst_time() {
        return first_time;
    }

    public void setFirst_time(String first_time) {
        this.first_time = first_time;
    }

    public String getHmsr() {
        return hmsr;
    }

    public void setHmsr(String hmsr) {
        this.hmsr = hmsr;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
