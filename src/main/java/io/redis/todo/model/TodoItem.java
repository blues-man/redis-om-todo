package io.redis.todo.model;

import org.springframework.data.annotation.Id;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Document
public class TodoItem {
  // Id Field, also indexed
  @Id
  @Indexed
  private String id;

  // Indexed for exact text matching
  @Searchable @NonNull
  private String description;

  @Indexed @NonNull
  private String owner;

  //Indexed for numeric matches
  @Indexed
  private boolean finished;

}