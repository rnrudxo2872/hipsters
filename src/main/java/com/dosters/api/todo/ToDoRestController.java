package com.dosters.api.todo;

import java.util.List;

import com.dosters.api.todo.service.DostersToDoService;
import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
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
    public String getToDoList(Model model) throws Exception {
        logger.info("get -> DoMain!");

        List<ToDoEntity> test = todoService.getAll();
        return test.toString();
    }

    @PostMapping("")
    public String createToDo(ToDoEntity todoEntity) throws Exception {
        logger.info("post -> insert ToDo!");

        CommonOutput result = todoService.createOne(todoEntity);
        return result.toString();
    }
}
