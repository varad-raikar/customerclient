package com.app.springboot.customerclient.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private boolean isError = true;
}
