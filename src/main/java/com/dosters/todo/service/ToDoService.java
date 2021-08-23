package com.dosters.todo.service;

import java.util.List;
import java.util.Optional;

import com.dosters.todo.domain.ToDoEntity;
import com.dosters.todo.repository.ToDoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    private final Logger logger = LoggerFactory.getLogger(ToDoService.class);
    private final ToDoRepository todoRepository;

    public ToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List getToDoList() throws Exception {
        Optional<ToDoEntity> test = todoRepository.findById(1L);
        if (test.isPresent()) {
            ToDoEntity testImpl = test.get();
            logger.info(testImpl.toString());
        }
        return null;
    }

    public void insertToDoList() throws Exception {
        ToDoEntity todo = new ToDoEntity();
        todo.setTitle("test");
        todoRepository.save(todo);
        logger.info("넣었다!");
    }
}
