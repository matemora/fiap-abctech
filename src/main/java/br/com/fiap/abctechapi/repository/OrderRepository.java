package br.com.fiap.abctechapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.abctechapi.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}