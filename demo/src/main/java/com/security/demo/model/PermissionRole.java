package com.security.demo.model;
import com.security.demo.model.Rol;
import com.security.demo.model.Page;
import jakarta.persistence.*;

@Entity
@Table(name = "permission_role")
public class PermissionRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_role_id")
    private Integer permissionRoleId;

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "id")
    private Page page;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Rol role;

    @Column (name = "action")
    private String action;
    public PermissionRole() {}

    public PermissionRole(Integer permissionRoleId,Page page, Rol role, String action) {
        this.permissionRoleId = permissionRoleId;
        this.page = page;
        this.role = role;
        this.action = action;
    }

    public Integer getPermissionRoleId() {
        return permissionRoleId;
    }

    public void setPermissionRoleId(Integer permissionRoleId) {
        this.permissionRoleId = permissionRoleId;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
