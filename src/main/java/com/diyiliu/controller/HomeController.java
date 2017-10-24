package com.diyiliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Description: HomeController
 * Author: DIYILIU
 * Update: 2017-10-24 09:04
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(@RequestParam(defaultValue = "world") String name, Model model){
        model.addAttribute("message", "你好," + name);

        return "index";
    }

    @RequestMapping("/search")
    public String search(){

        return "search";
    }
}
