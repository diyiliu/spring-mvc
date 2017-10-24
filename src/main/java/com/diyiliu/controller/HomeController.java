package com.diyiliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: HomeController
 * Author: DIYILIU
 * Update: 2017-10-24 09:04
 */

@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(@RequestParam(defaultValue = "world") String name, Model model){
        model.addAttribute("message", "你好," + name);

        return "indexPage";
    }

    @RequestMapping("/")
    public String home(){

        return "searchPage";
    }

    @RequestMapping("/result")
    public String hello(@RequestParam(defaultValue = "masterSpringMVC4") String search, Model model) {
        model.addAttribute("search", search);

        return "resultPage";
    }


    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String search(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String search = request.getParameter("search");

        if (search.toLowerCase().equals("struts")){

            redirectAttributes.addFlashAttribute("error", "struts 已过时, 请使用spring!");
            return "redirect:/";
        }

        redirectAttributes.addAttribute("search", search);
        return "redirect:result";
    }

}
