package com.dosters.domain;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity {
    @CreatedDate
    LocalDateTime createTime;

    @LastModifiedDate
    LocalDateTime updateTime;
}
