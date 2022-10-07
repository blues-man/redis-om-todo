package io.redis.todo.dao;

import com.redis.om.spring.repository.RedisDocumentRepository;

import io.redis.todo.model.TodoItem;


public interface TodoItemRepository  extends RedisDocumentRepository<TodoItem,String> {

    Iterable<TodoItem> findByDescription(String description);
    Iterable<TodoItem> findByOwner(String owner);
    Iterable<TodoItem> findByOwnerAndDescription(String owner, String description);

}
