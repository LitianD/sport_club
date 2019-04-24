package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;

public class ResCourse implements Serializable {

    /**
     * code :
     * error_msg :
     * data : {"id":"","name":"","coach":{"id":"","name":"","sex":"","age":"","phoneNumber":"","mail":"","content":""},"gym":{"id":"","name":"","address":""},"cost":"","content:":"","time":""}
     */

    private String code;
    private String error_msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id :
         * name :
         * coach : {"id":"","name":"","sex":"","age":"","phoneNumber":"","mail":"","content":""}
         * gym : {"id":"","name":"","address":""}
         * cost :
         * content: :
         * time :
         */

        private String id;
        private String name;
        private CoachBean coach;
        private GymBean gym;
        private String cost;
        //@com.google.gson.annotations.SerializedName("content:")
        private String _$Content230; // FIXME check this code
        private String time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CoachBean getCoach() {
            return coach;
        }

        public void setCoach(CoachBean coach) {
            this.coach = coach;
        }

        public GymBean getGym() {
            return gym;
        }

        public void setGym(GymBean gym) {
            this.gym = gym;
        }

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String get_$Content230() {
            return _$Content230;
        }

        public void set_$Content230(String _$Content230) {
            this._$Content230 = _$Content230;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public static class CoachBean {
            /**
             * id :
             * name :
             * sex :
             * age :
             * phoneNumber :
             * mail :
             * content :
             */

            private String id;
            private String name;
            private String sex;
            private String age;
            private String phoneNumber;
            private String mail;
            private String content;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getMail() {
                return mail;
            }

            public void setMail(String mail) {
                this.mail = mail;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class GymBean {
            /**
             * id :
             * name :
             * address :
             */

            private String id;
            private String name;
            private String address;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }
    }
}
