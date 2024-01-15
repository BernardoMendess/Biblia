package com.hb.biblia.dao;

import com.hb.biblia.model.Versiculo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VersiculoDAO extends CrudRepository<Versiculo, Long> {

    @Query("SELECT * FROM versiculos v WHERE (v.ver_liv_id = :idLivro AND v.ver_capitulo =:idCapitulo)" +
            " ORDER BY id ASC ")
    List<Versiculo> findVersiculos(long idLivro, long idCapitulo);
}
