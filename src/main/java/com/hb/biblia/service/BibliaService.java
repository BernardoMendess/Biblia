package com.hb.biblia.service;

import com.hb.biblia.dao.LivroDAO;
import com.hb.biblia.model.Livro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliaService {

    private LivroDAO livroDAO;

    public Livro findLivroById(long id){
        return livroDAO.findLivroById(id);
    }

    public List<Livro> findAllLivros(){
        return livroDAO.findAll();
    }
}
