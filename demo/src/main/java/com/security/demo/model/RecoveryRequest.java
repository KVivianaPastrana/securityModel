
package com.security.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;

public class RecoveryRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recovery_request_id")
    private Integer recoveryRequestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name="request_date")
    private String requestDate;
    
    @Column(name="token")
    private String token;

    public RecoveryRequest(Integer recoveryRequestId, Users user, String requestDate, String token) {
        this.recoveryRequestId = recoveryRequestId;
        this.user = user;
        this.requestDate = requestDate;
        this.token = token;
    }

    public RecoveryRequest() {
        
    }

    public Integer getRecoveryRequestId() {
        return recoveryRequestId;
    }

    public void setRecoveryRequestId(Integer recoveryRequestId) {
        this.recoveryRequestId = recoveryRequestId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
