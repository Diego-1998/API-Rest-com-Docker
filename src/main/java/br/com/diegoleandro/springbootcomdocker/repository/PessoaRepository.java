package br.com.diegoleandro.springbootcomdocker.repository;

import br.com.diegoleandro.springbootcomdocker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
