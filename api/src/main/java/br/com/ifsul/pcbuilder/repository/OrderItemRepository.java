package br.com.ifsul.pcbuilder.repository;

import br.com.ifsul.pcbuilder.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
