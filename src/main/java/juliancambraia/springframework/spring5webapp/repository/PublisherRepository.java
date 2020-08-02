package juliancambraia.springframework.spring5webapp.repository;

import juliancambraia.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
