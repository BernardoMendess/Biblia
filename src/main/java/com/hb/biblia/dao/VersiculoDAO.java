package com.hb.biblia.dao;

import com.hb.biblia.model.Versiculo;
import com.hb.biblia.model.VersiculoComDependencias;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VersiculoDAO extends CrudRepository<Versiculo, Long> {

    @Query("SELECT * FROM versiculos v WHERE (v.ver_liv_id = :idLivro AND v.ver_capitulo =:idCapitulo)" +
            " ORDER BY id ASC ")
    List<Versiculo> findVersiculos(long idLivro, long idCapitulo);

    @Query("SELECT l.liv_nome, v.ver_capitulo, v.ver_versiculo, v.ver_texto FROM versiculos v " +
            " INNER JOIN livros l ON l.id = v.ver_liv_id " +
            " WHERE v.ver_texto LIKE :query " +
            " ORDER BY v.id ASC ")
    List<VersiculoComDependencias> findByQuery(String query);
}
