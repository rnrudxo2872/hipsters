package com.dosters.api.todo;

import java.util.List;

import com.dosters.api.todo.service.DostersToDoService;
import com.dosters.dtos.CommonOutput;
import com.dosters.api.todo.domain.ToDoEntity;
import com.dosters.api.todo.dtos.ToDoDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        logger.info("REST : get -> getToDoList");

        List<ToDoDto.Info> test = todoService.getAll();
        return test;
    }

    @GetMapping("/{todoId}")
    public ToDoDto.Info getToDo(@PathVariable("todoId") Long id) throws Exception {
        logger.info("REST : get -> getToDo");

        if (id == null) {
            return (ToDoDto.Info) CommonOutput.getStatus(false, "error");
        }
        ToDoDto.Info retDto = (ToDoDto.Info) todoService.getOne(id);
        return retDto;
    }

    @PostMapping("")
    public String createToDo(ToDoDto.Post todoDto) throws Exception {
        logger.info("post -> insert ToDo!");

        CommonOutput result = todoService.createOne(todoDto);
        return result.toString();
    }
}
