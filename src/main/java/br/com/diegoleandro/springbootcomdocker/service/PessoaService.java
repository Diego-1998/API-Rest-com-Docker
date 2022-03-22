package br.com.diegoleandro.springbootcomdocker.service;

import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import br.com.diegoleandro.springbootcomdocker.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> find(){
       return pessoaRepository.findAll();
    }

}
