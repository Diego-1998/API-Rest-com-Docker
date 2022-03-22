package br.com.diegoleandro.springbootcomdocker.controller;

import br.com.diegoleandro.springbootcomdocker.controller.dto.PessoaResponse;
import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import br.com.diegoleandro.springbootcomdocker.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public List<PessoaResponse> findAll(){
        return pessoaService.find();
    }
}
