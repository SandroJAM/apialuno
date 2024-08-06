package br.com.projeto.apialuno.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projeto.apialuno.modelo.Aluno;
import br.com.projeto.apialuno.modelo.Mensagem;
import br.com.projeto.apialuno.repositorio.Repositorio;

@Service
public class Servico {

    @Autowired
    private Mensagem mensagem;

    @Autowired
    private Repositorio acao;

    public ResponseEntity<?> inserir(Aluno objAluno){
        if(objAluno.getNome().equals("")){
            mensagem.setMensagem("O nome do Aluno precisa ser preenchido!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(objAluno.getNota1() < 0){
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else if(objAluno.getNota2() < 0){
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(acao.save(objAluno), HttpStatus.OK);
        }
    }
    
}
