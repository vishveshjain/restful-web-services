package com.practice.restfulwebservices.helloWorld;

public class helloWorldMethod {
    private String message;
    public  helloWorldMethod(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "helloWorldMethod{" +
                "message='" + message + '\'' +
                '}';
    }
}
