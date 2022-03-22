package br.com.diegoleandro.springbootcomdocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.diegoleandro.springbootcomdocker")
@EntityScan(basePackages = "br.com.diegoleandro.springbootcomdocker.model")
public class SpringBootComDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootComDockerApplication.class, args);
	}

}
