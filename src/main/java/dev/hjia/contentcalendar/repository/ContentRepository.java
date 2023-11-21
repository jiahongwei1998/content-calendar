package dev.hjia.contentcalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import dev.hjia.contentcalendar.model.Content;
import dev.hjia.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
  List<Content> findAllByTitleContains(String keyword);

  @Query("""
      SELECT * from Content
      WHERE status=:status
      """)
  List<Content> listByStatus(Status status);
}
