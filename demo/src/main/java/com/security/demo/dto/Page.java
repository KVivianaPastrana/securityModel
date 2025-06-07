package com.security.demo.dto;

public class Page {
    private Integer pageId;
    private String pageName;
    public Page(Integer pageId, String pageName) {
        this.pageId = pageId;
        this.pageName = pageName;
    }
    public Page() {
        
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }       

}
