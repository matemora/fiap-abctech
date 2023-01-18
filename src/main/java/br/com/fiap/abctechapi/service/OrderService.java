package br.com.fiap.abctechapi.service;

import java.util.List;

import br.com.fiap.abctechapi.model.Order;

public interface OrderService {
    void saveOrder(Order order, List<Long> assistsArray) throws Exception;
}
