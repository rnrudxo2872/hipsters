package com.dosters.api.todo.service;

import java.util.List;
import java.util.Optional;

import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;
import com.dosters.api.todo.repository.ToDoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DostersToDoService implements ToDoService {

    private final Logger logger = LoggerFactory.getLogger(DostersToDoService.class);
    private final ToDoRepository todoRepository;

    public DostersToDoService(ToDoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<ToDoEntity> getAll() {
        return null;
    }

    @Override
    public ToDoEntity getOne() {
        Optional<ToDoEntity> test = todoRepository.findById(1L);
        if (test.isPresent()) {
            ToDoEntity testImpl = test.get();
            logger.info(testImpl.toString());
        }
        return null;
    }

    @Override
    public CommonOutput createOne(ToDoEntity todoEntity) {
        ToDoEntity todo = new ToDoEntity();
        todo.setContent("test");
        todoRepository.save(todo);
        logger.info("넣었다!");
        return null;
    }
}
