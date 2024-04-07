package com.org.irctc.helper;

public class ResponseUtil {
    public static ResponseObject buildResponse(Object results){
        ResponseObject response = ResponseObject.builder()
                .code("1")
                .type("SUCCESS")
                .message("Success")
                .results(results)
                .build();
        return response;
    }
}
