package com.dosters.domain;

import java.time.LocalDateTime;

public interface CommonProperty {
    LocalDateTime getCreateTime();

    LocalDateTime getUpdateTime();

    void setCreateTime(LocalDateTime createTime);

    void setUpdateTime(LocalDateTime updDateTime);
}
