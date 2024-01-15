package com.hb.biblia.dao;

import com.hb.biblia.model.Livro;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivroDAO extends CrudRepository<Livro, Long> {

    @Query("SELECT * FROM livros l WHERE l.liv_tes_id = :id")
    List<Livro> findAllLivrosByTestamento(long id);

    @Query("SELECT * FROM livros l WHERE l.id = :id")
    Livro findLivroById(long id);
}
