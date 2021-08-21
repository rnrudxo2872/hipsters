package com.dosters.home.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/todo")
public class DoController {
    private static Logger logger = LoggerFactory.getLogger(DoController.class);

    @GetMapping("")
    public String DoMain() {
        logger.info("get -> DoMain!");
        return "todo/doMain";
    }
}
