package com.wareline.api.controller;

import com.wareline.api.config.DBContextHolder;
import com.wareline.api.config.enums.DBTypeEnum;
import com.wareline.api.model.Post;
import com.wareline.api.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;	// test -> main DB
    // test?client=client-a -> Client A DB
    // test?client=client-b -> Client B DB
    @GetMapping("/test")
    @ResponseBody
    public Iterable<Post> getTest(@RequestParam String client) {
        switch (client) {
            case "client-a":
                DBContextHolder.setCurrentDb(DBTypeEnum.JALES);
                break;
            case "client-b":
                DBContextHolder.setCurrentDb(DBTypeEnum.CLIENT_B);
                break;
        }
        return postRepository.findAll();
    }

    // test?client=client-a -> Client A DB
    // test?client=client-b -> Client B DB
    @GetMapping("/test2")
    @ResponseBody
    public Iterable<Post> getTest2(@RequestParam String client) {
        DBContextHolder.setCurrentDb(DBTypeEnum.toEnum(client));
        return postRepository.findAll();
    }

    @GetMapping("/init-data")
    @ResponseBody
    public String initialData() {
        String name = "main - " + (new Random()).nextInt();
        postRepository.save(new Post("Main DB"));
            DBContextHolder.setCurrentDb(DBTypeEnum.JALES);
        postRepository.save(new Post("Client A DB"));
            DBContextHolder.setCurrentDb(DBTypeEnum.CLIENT_B);
        postRepository.save(new Post("Client B DB"));        return "Success!";
    }
}