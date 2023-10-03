package com.reactive.todo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Todo {
  @Id
  private String id;
  private String title;
  private String description;
  private Boolean completed;

  public Todo( String title, String description, Boolean completed ) {
    this.title = title;
    this.description = description;
    this.completed = completed;
  }
}
