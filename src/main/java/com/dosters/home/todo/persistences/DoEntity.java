package com.dosters.home.todo.persistences;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;

@Entity
@Builder
@Getter
public class DoEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;
}
