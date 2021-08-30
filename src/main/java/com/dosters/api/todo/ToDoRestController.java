package com.dosters.api.todo;

import java.util.List;

import com.dosters.api.todo.service.DostersToDoService;
import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;
import com.dosters.api.todo.dtos.ToDoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/todo")
public class ToDoRestController {
    private final static Logger logger = LoggerFactory.getLogger(ToDoRestController.class);
    private final DostersToDoService todoService;

    public ToDoRestController(DostersToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public List<ToDoDto.Info> getToDoList() throws Exception {
        logger.info("get -> DoMain!");

        List<ToDoDto.Info> test = todoService.getAll();
        return test;
    }

    @PostMapping("")
    public String createToDo(ToDoDto.post todoDto) throws Exception {
        logger.info("post -> insert ToDo!");

        CommonOutput result = todoService.createOne(todoDto);
        return result.toString();
    }
}
