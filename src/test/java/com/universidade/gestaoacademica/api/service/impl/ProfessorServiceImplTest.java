package com.universidade.gestaoacademica.api.service.impl;

import com.universidade.gestaoacademica.api.model.MatrizCurricular;
import com.universidade.gestaoacademica.api.repository.MatrizCurricularRepository;
import com.universidade.gestaoacademica.api.util.UtilMockado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class ProfessorServiceImplTest {

    @Mock
    private MatrizCurricularRepository matrizCurricularRepository;
    private UtilMockado utilMockado;

    @InjectMocks
    private ProfessorServiceImpl professorServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        utilMockado = new UtilMockado();
    }

    @Test
    public void testVisualizarMatrizCurricularExistente() {
        Long matrizCurricularId = 1L;

        MatrizCurricular matrizCurricularExistente = utilMockado.getMatrizCurricularMockada();
        matrizCurricularExistente.setId(matrizCurricularId);

        when(matrizCurricularRepository.findById(matrizCurricularId)).thenReturn(Optional.of(matrizCurricularExistente));

        MatrizCurricular resultado = professorServiceImpl.visualizarMatrizCurricular(matrizCurricularId);

//        verify(matrizCurricularRepository, times(1)).findById(matrizCurricularId);
        assertEquals(matrizCurricularExistente, resultado);
    }

    @Test
    public void testVisualizarMatrizCurricularNaoExistente() {
        Long matrizCurricularId = 1L;

        when(matrizCurricularRepository.findById(matrizCurricularId)).thenReturn(Optional.empty());

        MatrizCurricular resultado = professorServiceImpl.visualizarMatrizCurricular(matrizCurricularId);

//        verify(matrizCurricularRepository, times(1)).findById(matrizCurricularId);
        assertNull(resultado);
    }

}