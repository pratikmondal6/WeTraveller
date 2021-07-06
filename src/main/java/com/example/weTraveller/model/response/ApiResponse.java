package com.example.weTraveller.model.response;


public class ApiResponse {
    public boolean success;
    public boolean flag;
    public String message;
    public String total;
    public String additional;
    public Object additionalList;
    public String additionalField;
    public String userId;
    public Object data;
    public Object favdata;

    public ApiResponse(boolean success) {
        this.success = success;
    }

    public ApiResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getFavdata() {
        return favdata;
    }

    public void setFavdata(Object favdata) {
        this.favdata = favdata;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public String getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(String additionalField) {
        this.additionalField = additionalField;
    }

    public String getUserld() {
        return userId;
    }

    public Object getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(Object additionalList) {
        this.additionalList = additionalList;
    }

    public void setUserld(String userId) {
        this.userId = userId;
    }

    public void setSuccess(Object data) {
        this.success = true;
        this.data = data;
    }

    public void setError(String message) {
        this.success = false;
        this.message = message;
        this.data = null;
    }

}
