package com.reactive.todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.todo.handler.TodoHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class RouteConfiguration {
  private final TodoHandler todoHandler;

  @Bean
  public RouterFunction<ServerResponse> routes() {
    return RouterFunctions.route().GET( "/todos", todoHandler::getAll ).POST( "/todos", todoHandler::create )
        .POST( "/todos/many", todoHandler::createMany ).GET( "/todos/count", todoHandler::countAll )
        .GET( "/todos/stream", todoHandler::getAllStream )
        .GET( "/todos/stream/delay", todoHandler::getAllStreamWithDelay ).build();
  }
}
