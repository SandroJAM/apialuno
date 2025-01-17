package br.com.projeto.apialuno.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.apialuno.modelo.Aluno;
import br.com.projeto.apialuno.repositorio.Repositorio;
import br.com.projeto.apialuno.servico.Servico;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    @PostMapping("/apiAluno")
    public ResponseEntity<?> inserir(@RequestBody Aluno objAluno) {
        return servico.inserir(objAluno);
    }

    @GetMapping("/apiAluno")
    public ResponseEntity<?> consultar() {
        return servico.consultar();
    }

    @GetMapping("/apiAluno/{codigo}")
    public ResponseEntity<?> consultarPeloCodigo(@PathVariable int codigo) {
        return servico.consultarPeloCodigo(codigo);
    }

    @GetMapping("/apiAluno/contarRegistros")
    public long contarRegistros() {
        return acao.count();
    }

    @GetMapping("/")
    public List<Object[]> listagem() {
        return acao.listar();
    }

    @PutMapping("/apiAluno")
    public ResponseEntity<?> editar(@RequestBody Aluno objAluno) {
        return servico.editar(objAluno);
    }

    @DeleteMapping("/apiAluno/{codigo}")
    public ResponseEntity<?> deletar(@PathVariable int codigo) {
        return servico.deletar(codigo);
    }

}
