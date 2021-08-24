package com.dosters.todo.controller;

import com.dosters.todo.service.ToDoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private final static Logger logger = LoggerFactory.getLogger(ToDoController.class);
    private final ToDoService todoService;

    public ToDoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public String DoMain(Model model) throws Exception {
        logger.info("get -> DoMain!");
        todoService.getToDoList();
        model.addAttribute("title", "To Do");
        return "todo/doMain";
    }

    @PostMapping("/insert")
    public String insertTodo() throws Exception {
        logger.info("post -> insert ToDo!");
        todoService.insertToDoList();
        return "todo/doMain";
    }
}
