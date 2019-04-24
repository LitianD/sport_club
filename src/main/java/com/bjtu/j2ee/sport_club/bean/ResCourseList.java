package com.bjtu.j2ee.sport_club.bean;

import java.io.Serializable;
import java.util.List;

public class ResCourseList implements Serializable {

    /**
     * code :
     * error_msg :
     * data : [{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},{"id":"","name":"","coachName":"","coachID":"","gymName":"","gymID":"","address":"","cost":"","content:":"","Time":""},"..."]
     */

    private String code;
    private String error_msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
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
