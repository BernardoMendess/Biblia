package com.hb.biblia.controller;

import com.hb.biblia.service.BibliaService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BibliaController {

    private BibliaService bibliaService;

    @PostMapping("/versiculos")
    public ModelAndView busca(@RequestParam String query){
        val versiculos = bibliaService.findByQuery(query);

        return new ModelAndView("versiculo/busca/list")
                .addObject("versiculos", versiculos);
    }

    @GetMapping("/biblia")
    public ModelAndView getTelaInicio(){

        return new ModelAndView("list")
                .addObject("livros", bibliaService.findAllLivros());
    }

    @GetMapping("/capitulo/{id}")
    public ModelAndView getCapitulos(@PathVariable Long id){
        return new ModelAndView("capitulo/list")
                .addObject("livro", bibliaService.findLivroById(id));
    }

    @GetMapping("/versiculos/{idLivro}/{idCapitulo}")
    public ModelAndView getVersiculos(@PathVariable Long idLivro, @PathVariable Long idCapitulo){
        return new ModelAndView("versiculo/list")
                .addObject("livro", bibliaService.findLivroById(idLivro))
                .addObject("capitulo", idCapitulo)
                .addObject("versiculos", bibliaService.findVersiculosByCapitulo(idLivro, idCapitulo));
    }

}
