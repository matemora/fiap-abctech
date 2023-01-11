package br.com.fiap.abctechapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.fiap.abctechapi.model.Assist;
import br.com.fiap.abctechapi.repository.AssistRepository;
import br.com.fiap.abctechapi.service.impl.AssistServiceImpl;

import static org.mockito.Mockito.*;

import java.util.List;

@SpringBootTest
public class AssistServiceTest {
    @Mock
    private AssistRepository assistRepository;
    private AssistService assistService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(assistRepository);
        assistService = new AssistServiceImpl(assistRepository);
    }

    @DisplayName("List shoud contain items")
    @Test
    void list_success() {
        Assist assist = new Assist(1L, "Teste", "Teste description");
        Assist assist2 = new Assist(2L, "Teste", "Teste description");

        when(assistRepository.findAll()).thenReturn(List.of(assist, assist2));

        List<Assist> values = assistService.getServiceList();

        Assertions.assertEquals(values.size(), 2);
        Assertions.assertEquals(values.get(0).getId(), assist.getId());
        Assertions.assertEquals(values.get(1).getId(), assist2.getId());
    }

    @DisplayName("List shoud be empty")
    @Test
    void empty_list() {
        when(assistRepository.findAll()).thenReturn(List.of());

        List<Assist> values = assistService.getServiceList();

        Assertions.assertEquals(values.size(), 0);
    }
}
