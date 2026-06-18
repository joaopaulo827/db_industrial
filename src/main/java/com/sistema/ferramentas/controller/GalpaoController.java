/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.controller;


import com.sistema.ferramentas.model.GalpaoDTO;
import com.sistema.ferramentas.service.GalpaoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Aluno
 */
@Controller
public class GalpaoController {
    @Autowired
    private GalpaoService service;
        @GetMapping("/galpao")
    public String getFerramentas(Model model){
      List<GalpaoDTO> lista =  service.listarFerramentas();
      model.addAttribute("lista",lista);
      return "galpao";
    }
}
