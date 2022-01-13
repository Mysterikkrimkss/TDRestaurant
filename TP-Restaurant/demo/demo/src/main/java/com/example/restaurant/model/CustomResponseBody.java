package com.example.restaurant.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomResponseBody {
    private String timestamp;
    private int status;
    private String httpMessage;
    private String detail;
    private String path;

    public CustomResponseBody(int status, String httpMessage, String detail, String path) {
        this.status = status;
        this.httpMessage = httpMessage;
        this.detail = detail;
        this.path = path;

        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timestamp = timestamp.format(dateFormatter);
    }

    public CustomResponseBody returnRB(){
        return this;
    }

    public String returnRB2(){
        String response  = "{\"timestamp\": 1, \"status\": 1, \"httpMessage\": 110, \"detail\": \"paris\", \"path\": \"nimes\"}";
        return response;
    }

}
