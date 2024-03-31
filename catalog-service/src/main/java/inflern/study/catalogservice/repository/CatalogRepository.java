package inflern.study.catalogservice.repository;

import inflern.study.catalogservice.model.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {
}
