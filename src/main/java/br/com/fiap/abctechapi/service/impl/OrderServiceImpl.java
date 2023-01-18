package br.com.fiap.abctechapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.fiap.abctechapi.handler.exception.MaxAssistsException;
import br.com.fiap.abctechapi.handler.exception.MinAssistsException;
import br.com.fiap.abctechapi.model.Assist;
import br.com.fiap.abctechapi.model.Order;
import br.com.fiap.abctechapi.repository.AssistRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private AssistRepository assistRepository;

    public OrderServiceImpl(
        @Autowired OrderRepository orderRepository, @Autowired AssistRepository assistRepository) {
        this.orderRepository = orderRepository;
        this.assistRepository = assistRepository;
    }
    @Override
    public void saveOrder(Order order, List<Long> assistsArray) throws Exception {
        ArrayList<Assist> assists = new ArrayList<>();
        assistsArray.forEach(i -> {
            Assist assist = assistRepository.findById(i).orElseThrow();
            assists.add(assist);
        });
        order.setServices(assists);

        if (!order.hasMinAssists()) {
            throw new MinAssistsException("Invalid assists", "Mínimo número de assistências não fornecido.");
        }

        if(order.exceedsMaxAssists()) {
            throw new MaxAssistsException("Invalid assists", "Máximo número de assistências excedido.");
        }

        orderRepository.save(order);
    }
    
}
