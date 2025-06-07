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
 public Integer getId() {
     return id;
 }
 public void setId(Integer id) {
     this.id = id;
 }
 public String getName() {
     return name;
 }
 public void setName(String name) {
     this.name = name;
 }
}
