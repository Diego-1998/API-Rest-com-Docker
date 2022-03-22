package br.com.diegoleandro.springbootcomdocker.controller;

import br.com.diegoleandro.springbootcomdocker.controller.dto.PessoaResponse;
import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import br.com.diegoleandro.springbootcomdocker.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/")
    public List<PessoaResponse> findAll(){
        var pessoas = pessoaService.find();
        return pessoas
                .stream()
                .map(PessoaResponse::converter)
                .collect(Collectors.toList());
    }
}
