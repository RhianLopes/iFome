package br.com.ifsul.pcbuilder.repository;

import br.com.ifsul.pcbuilder.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
