package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;
import java.util.List;

public class ResCoach implements Serializable {

    /**
     * code :
     * error_msg :
     * data : {"id":"","name":"","age":"","sex":"","phoneNumber":"","mail":"","content":"","courses":[{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},"..."]}
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
         * age :
         * sex :
         * phoneNumber :
         * mail :
         * content :
         * courses : [{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},"..."]
         */

        private String id;
        private String name;
        private String age;
        private String sex;
        private String phoneNumber;
        private String mail;
        private String content;
        private List<CoursesBean> courses;

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

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
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

        public List<CoursesBean> getCourses() {
            return courses;
        }

        public void setCourses(List<CoursesBean> courses) {
            this.courses = courses;
        }

        public static class CoursesBean {
            /**
             * id :
             * name :
             * coachName :
             * coachID :
             * gymName :
             * gymID :
             * address :
             * cost :
             * content: :
             * Time :
             */

            private String id;
            private String name;
            private String coachName;
            private String coachID;
            private String gymName;
            private String gymID;
            private String address;
            private String cost;
            //@com.google.gson.annotations.SerializedName("content:")
            private String _$Content206; // FIXME check this code
            private String Time;

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

            public String getCoachName() {
                return coachName;
            }

            public void setCoachName(String coachName) {
                this.coachName = coachName;
            }

            public String getCoachID() {
                return coachID;
            }

            public void setCoachID(String coachID) {
                this.coachID = coachID;
            }

            public String getGymName() {
                return gymName;
            }

            public void setGymName(String gymName) {
                this.gymName = gymName;
            }

            public String getGymID() {
                return gymID;
            }

            public void setGymID(String gymID) {
                this.gymID = gymID;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCost() {
                return cost;
            }

            public void setCost(String cost) {
                this.cost = cost;
            }

            public String get_$Content206() {
                return _$Content206;
            }

            public void set_$Content206(String _$Content206) {
                this._$Content206 = _$Content206;
            }

            public String getTime() {
                return Time;
            }

            public void setTime(String Time) {
                this.Time = Time;
            }
        }
    }
}
