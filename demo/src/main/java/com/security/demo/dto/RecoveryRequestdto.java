package com.security.demo.dto;

public class RecoveryRequestdto {
    private Integer recoveryRequestId;
    private String requestDate;
    private String token;
    public RecoveryRequestdto(Integer recoveryRequestId, String requestDate, String token) {
        this.recoveryRequestId = recoveryRequestId;
        this.requestDate = requestDate;
        this.token = token;
    }
    public RecoveryRequestdto() {
        
    }

    public Integer getRecoveryRequestId() {
        return recoveryRequestId;
    }

    public void setRecoveryRequestId(Integer recoveryRequestId) {
        this.recoveryRequestId = recoveryRequestId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }   
}
