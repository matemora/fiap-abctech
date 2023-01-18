package br.com.fiap.abctechapi.application;

import java.util.List;

import br.com.fiap.abctechapi.application.dto.AssistDto;

public interface AssistApplication {
    List<AssistDto> getAssists();
}
