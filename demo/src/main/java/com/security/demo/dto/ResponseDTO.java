package com.security.demo.dto;

    public class ResponseDTO {
        private String message;
        private boolean success;
        private Object data;
        
        // Constructor original con tres parámetros
        public ResponseDTO(String message, boolean success, Object data) {
            this.message = message;
            this.success = success;
            this.data = data;
        }
        
        // Nuevo constructor para dos parámetros String
        public ResponseDTO() {
           
        }
    
    // Getters y setters
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isSuccess() {
        return success;
    }
    
    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public Object getData() {
        return data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
}