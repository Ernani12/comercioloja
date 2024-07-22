package com.api.produtos.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.api.produtos.service.ListaDesejosService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/lista-desejos")
public class ListaDesejosController {

    @Autowired
    private ListaDesejosService listaDesejosService;
 
    @GetMapping("/mostrarpagina")
    public String mostrarListaDesejos() {
        return "listadesejos";
    }

    @GetMapping("/meusdesejos")
    public String listarDesejos(Model model) {
        model.addAttribute("listad", listaDesejosService.listarDesejos());
        return "listadesejos";
    }
 
    @PostMapping("/adicionar/{codigo}")
    public String adicionarProduto(@PathVariable String codigo) {
        listaDesejosService.adicionarProduto(codigo);
        return "redirect:/lista-desejos/meusdesejos";
    }


    @PostMapping("/remover/{codigo}")
    public String removerProduto(@PathVariable String codigo) {
        listaDesejosService.removerProduto(codigo);
        return "redirect:/lista-desejos/meusdesejos";
    }
  
}
