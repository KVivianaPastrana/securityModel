package com.security.demo.dto;

public class PermissionRoledto {
 private Integer permissionRoleId;
 private String permissionName;
 private String roleName;
 public PermissionRoledto(Integer permissionRoleId, String permissionName, String roleName) {
     this.permissionRoleId = permissionRoleId;
     this.permissionName = permissionName;
     this.roleName = roleName;
 }
 public PermissionRoledto() {
     
 }
 public Integer getPermissionRoleId() {
     return permissionRoleId;
 }
 public void setPermissionRoleId(Integer permissionRoleId) {
     this.permissionRoleId = permissionRoleId;
 }
 
 public String getPermissionName() {
     return permissionName;
 }
 public void setPermissionName(String permissionName) {
     this.permissionName = permissionName;
 }
 public String getRoleName() {
     return roleName;
 }
 public void setRoleName(String roleName) {
     this.roleName = roleName;
 }  
}
