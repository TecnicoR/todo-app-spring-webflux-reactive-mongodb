package com.reactive.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TodoDto {
  private String id;
  private String title;
  private String description;
  private Boolean completed;
}
