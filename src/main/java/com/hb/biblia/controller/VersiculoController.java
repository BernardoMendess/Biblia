package com.hb.biblia.controller;

import com.hb.biblia.service.BibliaService;
import com.hb.biblia.service.VersiculoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("/versiculo")
public class VersiculoController {

    private VersiculoService versiculoService;

    private BibliaService bibliaService;

    @PostMapping()
    public String buscaVersiculos(@RequestParam String query, Model model){
        if (query == null || query.length() < 4) {
            return "redirect:/biblia";
        }

        model.addAttribute("query", query);
        model.addAttribute("versiculos",  versiculoService.findByQuery(query));
        return "versiculo/busca/list";
    }

    @GetMapping("/{idLivro}/{idCapitulo}")
    public ModelAndView getVersiculos(@PathVariable Long idLivro, @PathVariable Long idCapitulo){
        return new ModelAndView("versiculo/list")
                .addObject("livro", bibliaService.findLivroById(idLivro))
                .addObject("capitulo", idCapitulo)
                .addObject("versiculos", versiculoService.findVersiculosByCapitulo(idLivro, idCapitulo));
    }

    @GetMapping("/retroceder/{idLivro}/{idCapitulo}")
    public ModelAndView getACapituloAnterior(@PathVariable Long idLivro, @PathVariable Long idCapitulo){
        if(idLivro != 1){
            if(idCapitulo == 1){
                idLivro -= 1;
                idCapitulo = (long) bibliaService.findLivroById(idLivro).livCapitulo();
            } else {
                idCapitulo -= 1;
            }
        } else if(idLivro == 1 && idCapitulo != 1){
            idCapitulo -= 1;
        }
        return getVersiculos(idLivro, idCapitulo);
    }

    @GetMapping("/avancar/{idLivro}/{idCapitulo}")
    public ModelAndView getCapituloProximo(@PathVariable Long idLivro, @PathVariable Long idCapitulo){
        if(idLivro != 66){
            if(idCapitulo == bibliaService.findLivroById(idLivro).livCapitulo()){
                idLivro += 1;
                idCapitulo = 1L;
            } else {
                idCapitulo += 1;
            }
        } else if(idLivro == 66 && idCapitulo != 22){
            idCapitulo += 1;
        }
        return getVersiculos(idLivro, idCapitulo);
    }

}
