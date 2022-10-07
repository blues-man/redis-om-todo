package io.redis.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.redis.todo.dao.TodoItemRepository;
import io.redis.todo.model.TodoItem;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/todolist")
public class TodoListController {
    @Autowired
    TodoItemRepository repo;

    @GetMapping("all")
    Iterable<TodoItem> all() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    Optional<TodoItem> byId(@PathVariable String id) {
        return repo.findById(id);
    }

    @GetMapping("owner")
    Iterable<TodoItem> byOwner(@RequestParam("owner") String owner) {
        return repo.findByOwner(owner);
    }

    @GetMapping("description")
    Iterable<TodoItem> byDescription(@RequestParam("description") String description) {
        return repo.findByDescription(description);
    }
    
    @PostMapping("/api/todolist")
    public TodoItem create(@RequestBody TodoItem newItem){
        return repo.save(newItem);
    }

    @PostMapping("{id}")
    public void delete(@PathVariable String id) throws Exception {
        try {
            Optional<TodoItem> todoItem = repo.findById(id);
            if (todoItem.isPresent()) {
                repo.deleteById(id);
            }
        } catch (Exception e) {
            throw new Exception("Item not found " + id);
        }
    }

}
