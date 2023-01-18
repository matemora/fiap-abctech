package br.com.fiap.abctechapi.application.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDto {
    private Long operatorId;
    private List<Long> assists;
    private OrderLocationDto start;
    private OrderLocationDto end;
}
