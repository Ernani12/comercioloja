package com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.api.produtos.model.Cliente;
import com.api.produtos.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/register")
    public String register(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            clienteService.registerUser(email, password);
            return "redirect:/auth/login"; // Redireciona para a página de login após registro bem-sucedido
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage()); // Adiciona a mensagem de erro ao modelo
            return "register"; // Retorna à página de registro com mensagem de erro
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        try {
            Cliente user = clienteService.loginUser(email, password); // Valida e obtém o usuário
            session.setAttribute("user", user); // Armazena o usuário na sessão
            return "redirect:/index"; // Redireciona para a página inicial após login bem-sucedido
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage()); // Adiciona a mensagem de erro ao modelo
            return "login"; // Retorna à página de login com mensagem de erro
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retorna o template de login
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Retorna o template de registro
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalida a sessão do usuário
        return "redirect:/auth/login"; // Redireciona para a página de login
    }

    @GetMapping("/index")
    public String index() {
        return "index"; // Retorna a página inicial
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/auth/login"; // Redireciona para a página de login
    }
}
