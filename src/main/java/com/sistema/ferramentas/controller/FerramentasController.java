/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.controller;


import com.sistema.ferramentas.model.FerramentasDTO;
import com.sistema.ferramentas.service.FerramentasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Aluno
 */
@Controller
public class FerramentasController {
    @Autowired
    private FerramentasService service;
     @GetMapping("/")
    public String home() {
        return "redirect:/ferramentas";
    }
    @GetMapping("/ferramentas")
    public String getFerramentas(Model model){
      List<FerramentasDTO> lista =  service.listarFerramentas();
      model.addAttribute("listar",lista);
      return "ferramentas";
    }
    @GetMapping("/editar")
public String editar(@RequestParam int id, Model model) {

    FerramentasDTO ferramenta = service.buscarPorId(id);

    model.addAttribute("ferramenta", ferramenta);

    return "editar";
}
    @PostMapping("/ferramentas/salvar")
    public String salvarDados(@ModelAttribute FerramentasDTO ferramentas){
    service.atualizar(ferramentas);
    return "redirect:/ferramentas";        
    }    
}
