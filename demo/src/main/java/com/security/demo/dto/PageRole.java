package com.security.demo.dto;

public class PageRole {

    private Integer pageRoleId;
    private String pageName;
    private String roleName;
    public PageRole(Integer pageRoleId, String pageName, String roleName) {
        this.pageRoleId = pageRoleId;
        this.pageName = pageName;
        this.roleName = roleName;
    }
    public PageRole() {
        
    }

    public Integer getPageRoleId() {
        return pageRoleId;
    }

    public void setPageRoleId(Integer pageRoleId) {
        this.pageRoleId = pageRoleId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
