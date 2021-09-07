package com.dosters.api.todo.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dosters.domain.CommonEntityListener;
import com.dosters.domain.CommonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "todo")
@EntityListeners(value = { CommonEntityListener.class })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ToDoEntity implements CommonProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private long user_id;

    @Column(nullable = false)
    private LocalDateTime createTime;

    @Column(nullable = false)
    private LocalDateTime updateTime;
}
