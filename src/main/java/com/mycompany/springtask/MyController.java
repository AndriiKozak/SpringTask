package com.mycompany.springtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

    @Autowired
    private MyRepository repository;

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("entities", repository.findAll());
        return "list";
    }

    @RequestMapping("/addNew")
    public String add() {
        return "edit";
    }

    @RequestMapping("/delete")
    public String delete(@ModelAttribute("entity") MyEntity entity) {
        repository.delete(entity);
        return "redirect:list";
    }

    @RequestMapping("/save")
    public String edit(@ModelAttribute MyEntity entity) {
        repository.save(entity);
        return "redirect:list";
    }
}
