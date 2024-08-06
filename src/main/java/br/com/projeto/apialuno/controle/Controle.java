package br.com.projeto.apialuno.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apialuno.repositorio.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;
    
}
