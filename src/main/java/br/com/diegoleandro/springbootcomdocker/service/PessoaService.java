package br.com.diegoleandro.springbootcomdocker.service;

import br.com.diegoleandro.springbootcomdocker.controller.dto.PessoaResponse;
import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import br.com.diegoleandro.springbootcomdocker.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaResponse> find(){
       var pessoas = pessoaRepository.findAll();
        return null;
    }

}
