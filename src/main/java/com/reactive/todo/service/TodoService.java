package com.reactive.todo.service;

import org.springframework.stereotype.Service;

import com.reactive.todo.dto.TodoDto;
import com.reactive.todo.entity.Todo;
import com.reactive.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoRepository todoRepository;

  public Flux<TodoDto> getAll() {
    return todoRepository.findAll()
        .map( todo -> new TodoDto( todo.getId(), todo.getTitle(), todo.getDescription(), todo.getCompleted() ) );
  }

  public Mono<TodoDto> create( Mono<TodoDto> todo ) {
    return todo.map( todoDto -> new Todo( todoDto.getTitle(), todoDto.getDescription(), todoDto.getCompleted() ) )
        .flatMap( todoRepository::insert ).map(
            todoMono -> new TodoDto( todoMono.getId(), todoMono.getTitle(), todoMono.getDescription(),
                todoMono.getCompleted() ) );
  }

  public Flux<TodoDto> create( Flux<TodoDto> todo ) {
    return todo.map( todoDto -> new Todo( todoDto.getTitle(), todoDto.getDescription(), todoDto.getCompleted() ) )
        .flatMap( todoRepository::insert ).map(
            todoMono -> new TodoDto( todoMono.getId(), todoMono.getTitle(), todoMono.getDescription(),
                todoMono.getCompleted() ) );
  }

  public Mono<Long> countAll() {
    return todoRepository.count();
  }
  
  public Flux<TodoDto> getAllStream() {
    return todoRepository.findAll().delayElements( java.time.Duration.ofMillis( 500 ) )
        .map( todo -> new TodoDto( todo.getId(), todo.getTitle(), todo.getDescription(), todo.getCompleted() ) );
  }
}
