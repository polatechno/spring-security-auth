package com.polatechno.security.inmemory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private")
public class PrivateController {

    @GetMapping
    public String helloWorldPrivate() {
        return "Hello world! From private endpoint...";
    }

    @GetMapping("user")
    public String helloWorldUserPrivate() {
        return "Hello world user! From private endpoint...";
    }

    @GetMapping("admin")
    public String helloWorldAdminPrivate() {
        return "Hello world admin! From private endpoint...";
    }

}
