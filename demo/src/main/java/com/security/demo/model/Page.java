package com.security.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
    


@Entity
@Table(name = "page")
public class Page {

@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí está el auto-increment
    @Column(name = "page_id")
    private Integer pageId; 

    @Column(name = "page_name")
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
