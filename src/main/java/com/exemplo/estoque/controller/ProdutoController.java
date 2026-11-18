package com.exemplo.estoque.controller;

import com.exemplo.estoque.model.Produto;
import com.exemplo.estoque.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/cadastro";
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarProduto(
            @Valid @ModelAttribute("produto") Produto produto,
            BindingResult resultado,
            RedirectAttributes redirectAttributes) {

        if (resultado.hasErrors()) {
            return "cadastro";
        }

        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "redirect:/estoque";
    }

    @GetMapping("/estoque")
    public String exibirEstoque(Model model) {
        model.addAttribute("produtos", produtoRepository.findAll(Sort.by(Sort.Direction.ASC, "nome")));
        return "estoque";
    }
}
