package com.reactive.todo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.todo.dto.TodoDto;
import com.reactive.todo.service.TodoService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TodoHandler {
  private final TodoService todoService;

  public Mono<ServerResponse> getAll( ServerRequest serverRequest ) {
    return ServerResponse.ok().body( todoService.getAll(), TodoDto.class );
  }

  public Mono<ServerResponse> create( ServerRequest serverRequest ) {
    return ServerResponse.ok().body( todoService.create( serverRequest.bodyToMono( TodoDto.class ) ), TodoDto.class );
  }

  public Mono<ServerResponse> createMany( ServerRequest serverRequest ) {
    return ServerResponse.ok().body( todoService.create( serverRequest.bodyToFlux( TodoDto.class ) ), TodoDto.class );
  }

  public Mono<ServerResponse> countAll( ServerRequest serverRequest ) {
    return ServerResponse.ok().body( todoService.countAll(), Long.class );
  }

  public Mono<ServerResponse> getAllStream( ServerRequest serverRequest ) {
    return ServerResponse.ok().contentType( MediaType.TEXT_EVENT_STREAM )
        .body( todoService.getAllStream(), TodoDto.class );
  }

  public Mono<ServerResponse> getAllStreamWithDelay( ServerRequest serverRequest ) {
    return ServerResponse.ok().body( todoService.getAllStream(), TodoDto.class );
  }
}
