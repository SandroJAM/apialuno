package br.com.projeto.apialuno.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.apialuno.modelo.Aluno;

@Repository
public interface Repositorio extends CrudRepository<Aluno, Integer>{
    int countByCodigo(int codigo);
    Aluno findByCodigo(int codigo);
    //@Query(value = "SELECT SUM(nota1 + nota2) / 2 from alunos", nativeQuery = true) int mediaNotas();
    @Query(value = "SELECT nome, nota1, nota2, (nota1 + nota2) / 2.0 AS media FROM alunos", nativeQuery = true) 
    List<Object[]> listar();
}
