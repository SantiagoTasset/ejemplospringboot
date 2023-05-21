package com.eoi.ejemplospringboot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @GetMapping(value={"","/"})
    public String mostrarIndex()
    {
        return "index";
    }

    @GetMapping("/holamundo")
    public String holaMundo()
    {
        return "holamundo.html";
    }




}
