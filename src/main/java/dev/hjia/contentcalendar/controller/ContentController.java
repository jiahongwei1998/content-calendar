package dev.hjia.contentcalendar.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.hjia.contentcalendar.model.Content;
import dev.hjia.contentcalendar.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContentController {
  private final ContentCollectionRepository repository;

  // Where there is only one constructor in the class, @Autowired is implicit
  public ContentController(ContentCollectionRepository repository) {
    this.repository = repository;
  }

  // Make a request and find all the pieces of content in the system
  @GetMapping("")
  public List<Content> findAll() {
    return repository.findAll();
  }

  // Create Read Update Delete - filter | paging ...
  @GetMapping("/{id}")
  public Content findById(@PathVariable Integer id) {
    return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
  }

  @PostMapping("")
  public void create(@RequestBody Content content) {
    repository.save(content);
  }

}
