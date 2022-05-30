package com.insside.login.models;

import javax.persistence.*;




@Entity
@Table (name = "USUARIOS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (unique = true, nullable = false)
    private Long        id;

    private String      userName;
    private String      password;
    private String      name;
    private String      lastName;
    private int         age;
    private ProfileRole profileRole;

    public User(){

    }

    public User(String userName, String password, String name, String lastName, int age, ProfileRole profileRole) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.profileRole = profileRole;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getuserName() {
        return userName;
    }
    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public ProfileRole getProfileRole() {
        return profileRole;
    }
    public void setProfileRole(ProfileRole profileRole) {
        this.profileRole = profileRole;
    }


    
}
