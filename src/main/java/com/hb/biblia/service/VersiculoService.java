package com.hb.biblia.service;

import com.hb.biblia.dao.VersiculoDAO;
import com.hb.biblia.model.Versiculo;
import com.hb.biblia.model.VersiculoComDependencias;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VersiculoService {

    private VersiculoDAO versiculoDAO;

    public List<Versiculo> findVersiculosByCapitulo(long idLivro, long idCapitulo){
        return versiculoDAO.findVersiculos(idLivro, idCapitulo);
    }

    public List<VersiculoComDependencias> findByQuery(String query){
        return versiculoDAO.findByQuery("%" + query + "%");
    }
}
