package com.mizuki.sinatv.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/8/28.
 */

public class UserInfoBean {

    /**
     * error_code : 10007
     * error_msg : 缺失必选参数 (uid)，请参考API文档
     * request : /live/my_info.json
     */

    private int error_code;
    private String error_msg;
    private String request;
    /**
     * result : {"list":[{"created_at":1502768860935,"updated_at":1502768860971,"id":1387933111222279,"user_data":{"sign":"😄","avatar":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2608404801,4206400884&f=23&gp=0.jpg","user_name":"水木"}}]}
     */

    private ResultBean result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        @Override
        public String toString() {
            return "ResultBean{" +
                    "list=" + list +
                    '}';
        }

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            @Override
            public String toString() {
                return "ListBean{" +
                        "created_at=" + created_at +
                        ", updated_at=" + updated_at +
                        ", id=" + id +
                        ", user_data=" + user_data +
                        '}';
            }

            /**
             * created_at : 1502768860935
             * updated_at : 1502768860971
             * id : 1387933111222279
             * user_data : {"sign":"😄","avatar":"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2608404801,4206400884&f=23&gp=0.jpg","user_name":"水木"}
             */

            private long created_at;
            private long updated_at;
            private long id;
            private UserDataBean user_data;

            public long getCreated_at() {
                return created_at;
            }

            public void setCreated_at(long created_at) {
                this.created_at = created_at;
            }

            public long getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(long updated_at) {
                this.updated_at = updated_at;
            }

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public UserDataBean getUser_data() {
                return user_data;
            }

            public void setUser_data(UserDataBean user_data) {
                this.user_data = user_data;
            }

            public static class UserDataBean {
                @Override
                public String toString() {
                    return "UserDataBean{" +
                            "sign='" + sign + '\'' +
                            ", avatar='" + avatar + '\'' +
                            ", user_name='" + user_name + '\'' +
                            '}';
                }

                /**
                 * sign : 😄
                 * avatar : https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2608404801,4206400884&f=23&gp=0.jpg
                 * user_name : 水木
                 */

                private String sign;
                private String avatar;
                private String user_name;

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getUser_name() {
                    return user_name;
                }

                public void setUser_name(String user_name) {
                    this.user_name = user_name;
                }
            }
        }
    }
}
