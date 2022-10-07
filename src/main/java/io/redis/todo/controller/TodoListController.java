package io.redis.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.redis.todo.dao.TodoItemRepository;
import io.redis.todo.model.TodoItem;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {
    @Autowired
    TodoItemRepository repo;

    @GetMapping("all")
    Iterable<TodoItem> all() {
    return repo.findAll();
    }
    
}
