package br.com.diegoleandro.springbootcomdocker.controller;

import br.com.diegoleandro.springbootcomdocker.controller.dto.PessoaRequest;
import br.com.diegoleandro.springbootcomdocker.controller.dto.PessoaResponse;
import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import br.com.diegoleandro.springbootcomdocker.repository.PessoaRepository;
import br.com.diegoleandro.springbootcomdocker.service.PessoaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {


    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;

    public PessoaController(PessoaRepository pessoaRepository, PessoaService pessoaService) {
        this.pessoaRepository = pessoaRepository;
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

    @GetMapping("/{pessoaId}")
    public PessoaResponse findById(@PathVariable Long pessoaId){
        var pessoa = pessoaRepository.getById(pessoaId);
        return PessoaResponse.converter(pessoa);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody PessoaRequest pessoaRequest){
        var pessoa = new Pessoa();
        pessoa.setNome(pessoaRequest.getNome());
        pessoa.setSobrenome(pessoaRequest.getSobrenome());
        pessoaRepository.save(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public void updatePerson(@PathVariable Long pessoaId,@RequestBody PessoaRequest pessoaRequest) throws Exception {
        var pessoa = pessoaRepository.findById(pessoaId);

        if(pessoa.isPresent()){
            var pessoaSave = pessoa.get();
            pessoaSave.setNome(pessoaRequest.getNome());
            pessoaSave.setSobrenome(pessoaRequest.getSobrenome());
            pessoaRepository.save(pessoaSave);
        }
        else{
            throw new Exception("Pessoa não encontrada");
        }
    }

}
