package com.dosters.domain;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CommonEntityListener {
    @PrePersist
    public void prePersist(Object obj) {
        if (obj instanceof CommonProperty) {
            ((CommonProperty) obj).setCreateTime(LocalDateTime.now());
            ((CommonProperty) obj).setUpdateTime(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object obj) {
        if (obj instanceof CommonProperty) {
            ((CommonProperty) obj).setUpdateTime(LocalDateTime.now());
        }
    }
}
