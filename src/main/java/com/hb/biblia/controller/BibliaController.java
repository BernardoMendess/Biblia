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

    @GetMapping("/biblia")
    public ModelAndView getLivros(){

        return new ModelAndView("list")
                .addObject("livros", bibliaService.findAllLivros());
    }

    @GetMapping("/capitulo/{id}")
    public ModelAndView getCapitulos(@PathVariable Long id){
        return new ModelAndView("capitulo/list")
                .addObject("livro", bibliaService.findLivroById(id));
    }
}
