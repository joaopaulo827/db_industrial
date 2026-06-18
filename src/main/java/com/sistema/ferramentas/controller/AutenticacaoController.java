package com.sistema.ferramentas.controller;

import com.sistema.ferramentas.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class AutenticacaoController {
    @Autowired
    public UsuarioService authservice;
    @GetMapping("/")
    public String home(
    HttpSession session
    ){
        Object token = session.getAttribute("token");
        
        if (token == null || token.toString().isBlank()) {
    return "redirect:/login";
}
        
        return "index";
    }
}
