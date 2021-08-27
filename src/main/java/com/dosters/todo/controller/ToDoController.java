package com.dosters.todo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private final static Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @GetMapping("")
    public String DoMain(Model model) throws Exception {
        logger.info("get -> DoMain!");

        model.addAttribute("title", "To Do");
        return "todo/doMain";
    }
}
