package br.com.fiap.abctechapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.abctechapi.model.Assist;

public interface AssistRepository extends JpaRepository<Assist, Long> {
    
}
