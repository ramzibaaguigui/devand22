package com.devfest.api.retrofit;

public class ApiResponse<T>{
        private T data;
        private boolean success;
        private String message;

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

}
