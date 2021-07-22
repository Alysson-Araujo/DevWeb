package br.com.farmacia.projetofinalweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class ProjetoFinalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFinalWebApplication.class, args);
	}

}
