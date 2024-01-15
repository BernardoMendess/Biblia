package com.hb.biblia.controller;

import com.hb.biblia.service.BibliaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class BibliaController {

    private BibliaService bibliaService;

    @GetMapping("/testamento")
    public String exibirTestamento(){
        return "tela1";
    }

    @GetMapping("/livro/{id}")
    public ModelAndView exibirLivros(@PathVariable Long id){
        return new ModelAndView("tela2")
                .addObject("livros", bibliaService.findAllLivrosByTestamento(id));
    }

    @GetMapping("/capitulo/{id}")
    public ModelAndView exibirCapitulo(@PathVariable Long id){
        return new ModelAndView("tela3")
                .addObject("livro", bibliaService.findLivroById(id));
    }

    @GetMapping("/versiculos/{idLivro}/{idCapitulo}")
    public ModelAndView versiculos(@PathVariable Long idLivro, @PathVariable Long idCapitulo){
        return new ModelAndView("tela4")
                .addObject("livro", bibliaService.findLivroById(idLivro))
                .addObject("capitulo", idCapitulo)
                .addObject("versiculos", bibliaService.findVersiculosByCapitulo(idLivro, idCapitulo));
    }

}
