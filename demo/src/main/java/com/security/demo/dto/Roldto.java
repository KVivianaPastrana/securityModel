package com.security.demo.dto;

public class Roldto {
 private Integer id;
 private String name;
 public Roldto(Integer id, String name) {
     this.id = id;
     this.name = name;
 }
 public Roldto() {
     
 }
 public Integer getRolId() {
     return id;
 }
 public void setRolId(Integer id) {
     this.id = id;
 }
 public String getRolName() {
     return name;
 }
 public void setRolName(String name) {
     this.name = name;
 }
}
