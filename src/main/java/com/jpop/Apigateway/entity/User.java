package com.jpop.Apigateway.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    private String firstname;

    private String lastname;

    private String username;

    private String useremail;

    private String phoneno;

    private String password;

    public User() {
    }

    public User(Long userid, String firstname, String lastname, String username, String useremail, String phoneno, String password) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.useremail = useremail;
        this.phoneno = phoneno;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid.equals(user.userid) &&
                firstname.equals(user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                username.equals(user.username) &&
                useremail.equals(user.useremail) &&
                phoneno.equals(user.phoneno) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userid +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", userName='" + username + '\'' +
                ", userEmail='" + useremail + '\'' +
                ", phoneNo='" + phoneno + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
