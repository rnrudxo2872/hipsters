package com.dosters.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dosters.todo.domain.ToDoEntity;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
