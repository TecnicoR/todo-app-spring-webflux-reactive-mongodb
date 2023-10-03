package com.reactive.todo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.reactive.todo.entity.Todo;

@Repository
public interface TodoRepository extends ReactiveMongoRepository<Todo, String> {
}
