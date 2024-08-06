package br.com.projeto.apialuno.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.apialuno.modelo.Aluno;

@Repository
public interface Repositorio extends CrudRepository<Aluno, Integer>{
    
}
