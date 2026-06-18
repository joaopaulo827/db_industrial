/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.service;

import com.sistema.ferramentas.model.UsuarioDTO;
import com.sistema.ferramentas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
     public String logar(UsuarioDTO user) {
        String message = "";
        if (user.getLogin().isEmpty()) {
            message = "Login não preenchido";
        } else if (user.getSenha().isEmpty()) {
            message = "Senha não preenchida";
        }

        if (!message.isEmpty()) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), message);
        }
    return message;
    }
}
