package com.dosters.timeline.repository;

import com.dosters.timeline.domain.timelineEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface timelineRepo extends JpaRepository<timelineEntity,Long> {
}
