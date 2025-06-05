package com.security.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "page_role")
public class PageRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_role_id")
    private Integer pageRoleId;

    @ManyToOne
    @JoinColumn(name = "page_id", referencedColumnName = "id")
    private Page page;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Rol role;

    public PageRole() {}

    public PageRole(Page page, Rol role) {
        this.page = page;
        this.role = role;
    }

    public Integer getPageRoleId() {
        return pageRoleId;
    }

    public void setPageRoleId(Integer pageRoleId) {
        this.pageRoleId = pageRoleId;
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
}
