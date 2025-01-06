package com.example.link.controllers;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@Controller
public class HomeController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "board/post_list";
    }
}
