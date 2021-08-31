package com.dosters.member.domain;

import java.sql.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member", schema = "dosters")
public class SignUpEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userName;

    @Column(length = 50)
    private String userEmail;

    @Column(length = 20)
    private String userPhone;

    @Column(length = 45)
    private String userPass;

    private Date userBirth;

    @Column(length = 45)
    private String userId;

    public SignUpEntity(String userEmail, String userPhone, String userPass, Date userBirth, String userId) {
        this.userBirth = userBirth;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userPass = userPass;
        this.userPhone = userPhone;
    }


}
