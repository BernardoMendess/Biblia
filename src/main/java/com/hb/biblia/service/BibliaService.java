package com.hb.biblia.service;

import com.hb.biblia.dao.LivroDAO;
import com.hb.biblia.dao.VersiculoDAO;
import com.hb.biblia.model.Livro;
import com.hb.biblia.model.Versiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliaService {

    private LivroDAO livroDAO;
    private VersiculoDAO versiculoDAO;

    public List<Livro> findAllLivrosByTestamento(long id){
        return livroDAO.findAllLivrosByTestamento(id);
    }

    public Livro findLivroById(long id){
        return livroDAO.findLivroById(id);
    }

    public List<Versiculo> findVersiculosByCapitulo(long idLivro, long idCapitulo){
        return versiculoDAO.findVersiculos(idLivro, idCapitulo);
    }
}
