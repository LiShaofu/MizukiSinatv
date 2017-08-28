package com.mizuki.sinatv.bean;

import java.io.Serializable;

/**
 * Created by xiaoyuan on 16/11/10.
 */
public class UploadBean implements Serializable {

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    /**
     *  thumbnail_pic : http: //ofdx4t772.bkt.clouddn.com/984122601308166?imageView2/1/w/300/h/300
     * bmiddle_pic : http: //ofdx4t772.bkt.clouddn.com/984122601308166?imageView2/1/w/600/h/600
     * original_pic : http: //ofdx4t772.bkt.clouddn.com/984122601308166?imageView2
     */

    private ResultBean result;
    /**
     * error_code : 0
     */

    private int error_code;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }


    public static class ResultBean implements Serializable{

        private String thumbnail_pic;
        private String bmiddle_pic;
        private String original_pic;

        public String getThumbnail_pic() {
            return thumbnail_pic;
        }

        public void setThumbnail_pic(String thumbnail_pic) {
            this.thumbnail_pic = thumbnail_pic;
        }

        public String getBmiddle_pic() {
            return bmiddle_pic;
        }

        public void setBmiddle_pic(String bmiddle_pic) {
            this.bmiddle_pic = bmiddle_pic;
        }

        public String getOriginal_pic() {
            return original_pic;
        }

        public void setOriginal_pic(String original_pic) {
            this.original_pic = original_pic;
        }
    }
}
