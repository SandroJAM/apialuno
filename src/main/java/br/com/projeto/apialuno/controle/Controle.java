package br.com.projeto.apialuno.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apialuno.modelo.Aluno;
// import br.com.projeto.apialuno.repositorio.Repositorio;
import br.com.projeto.apialuno.servico.Servico;

@RestController
public class Controle {

    // @Autowired
    // private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/apiAluno")
    public ResponseEntity<?> inserir(@RequestBody Aluno objAluno){
        return servico.inserir(objAluno);
    }
    
}
