package dev.hjia.contentcalendar.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.hjia.contentcalendar.model.Content;
import dev.hjia.contentcalendar.model.Status;
import dev.hjia.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {
  private final List<Content> contents = new ArrayList<>();

  public ContentCollectionRepository() {
  }

  public List<Content> findAll() {
    return contents;
  }

  public Optional<Content> findById(Integer id) {
    return contents.stream().filter(c -> c.id().equals(id)).findFirst();
  }

  @PostConstruct
  private void init() {
    Content content = new Content(1, "My First Blog Post", "My first blog post", Status.IDEA, Type.ARTICLE,
        LocalDateTime.now(), null, "");
    contents.add(content);
  }

  public void save(Content content) {
    contents.removeIf(c -> c.id().equals(content.id()));
    contents.add(content);
  }

  public boolean existById(Integer id) {
    return contents.stream().filter(c -> c.id().equals(id)).count() == 1;
  }

  public void delete(Integer id) {
    contents.removeIf(c -> c.id().equals(id));
  }

}
