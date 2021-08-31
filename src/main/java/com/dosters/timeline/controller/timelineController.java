package com.dosters.timeline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/timeline")
public class timelineController {
    
    @GetMapping()
    public String timeline(Model model) {

        model.addAttribute("title", "timeline");
        return "timeline/timeline";
    }


}
