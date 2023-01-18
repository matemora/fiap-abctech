package br.com.fiap.abctechapi.application.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.abctechapi.application.AssistApplication;
import br.com.fiap.abctechapi.application.dto.AssistDto;
import br.com.fiap.abctechapi.service.AssistService;

@Component
public class AssistApplicationImpl implements AssistApplication {

    private AssistService assistService;
    public AssistApplicationImpl(@Autowired AssistService assistService) {
        this.assistService = assistService;
    }
    @Override
    public List<AssistDto> getAssists() {
        return this.assistService.getServiceList().stream().map(it -> new AssistDto(it.getId(), it.getName(), it.getDescription())).collect(Collectors.toList());
    }
    
}
