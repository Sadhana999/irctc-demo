package com.org.irctc.helper;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ResponseObject {

    private String code;
    private String type;
    private String message;
    private Object results;

    public ResponseObject(String code, String message, Object results) {
        super();
        this.code = code;
        this.message = message;
        this.results = results;
    }

}