package com.example.demo.domain;

import javax.persistence.*;

@Table(name = "user")
@Entity
public class User {
  // 主键自增int(10)对应long
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long uid;

  private String uname;

  private String password;


  public long getUid() {
    return this.uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }

  public String getUname() {
    return this.uname;
  }
  
  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
