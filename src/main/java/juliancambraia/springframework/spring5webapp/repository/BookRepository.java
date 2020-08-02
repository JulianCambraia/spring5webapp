package juliancambraia.springframework.spring5webapp.repository;

import juliancambraia.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
