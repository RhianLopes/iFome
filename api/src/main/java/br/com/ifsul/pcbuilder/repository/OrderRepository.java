package br.com.ifsul.pcbuilder.repository;

import br.com.ifsul.pcbuilder.domain.Order;
import br.com.ifsul.pcbuilder.domain.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(OrderStatus status);

}
