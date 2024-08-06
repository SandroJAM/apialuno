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

    // Método para inserir Alunos
    public ResponseEntity<?> inserir(Aluno objAluno) {

        if (objAluno.getNome().equals("")) {
            mensagem.setMensagem("O nome do Aluno precisa ser preenchido!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (objAluno.getNota1() < 0) {
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (objAluno.getNota2() < 0) {
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(objAluno), HttpStatus.OK);
        }

    }

    // Método para consultar Alunos
    public ResponseEntity<?> consultar() {

        return new ResponseEntity<>(acao.findAll(), HttpStatus.OK);

    }

    // Método para consultar Aluno através do código
    public ResponseEntity<?> consultarPeloCodigo(int codigo) {

        if (acao.countByCodigo(codigo) == 0) {
            mensagem.setMensagem("Não foi encontradp nenhum Aluno!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.findByCodigo(codigo), HttpStatus.OK);
        }

    }

    // Método para editar Alunos
    public ResponseEntity<?> editar(Aluno objAluno) {

        if(acao.countByCodigo(objAluno.getCodigo()) == 0){
            mensagem.setMensagem("O código informado não existe!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else if (objAluno.getNome().equals("")) {
            mensagem.setMensagem("O nome do Aluno precisa ser preenchido!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (objAluno.getNota1() < 0) {
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (objAluno.getNota2() < 0) {
            mensagem.setMensagem("Informe uma Nota válida!");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(acao.save(objAluno), HttpStatus.OK);
        }

    }

    // Método para deletar Aluno
    public ResponseEntity<?> deletar(int codigo){

        if(acao.countByCodigo(codigo) == 0){
            mensagem.setMensagem("O código informado não existe!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }else{
            Aluno objAluno = acao.findByCodigo(codigo);
            acao.delete(objAluno);

            mensagem.setMensagem("Aluno removido com sucesso!");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        }

    }

}
