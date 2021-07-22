package br.com.farmacia.funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

@RestController
public class FuncionarioController {
/*
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@GetMapping(value = "/funcionario")
	public String listaFuncionario(Model model) {

		List<FuncionarioResponse> funcionarioResponse = new ArrayList<>();

		List<Funcionario> funcionarioFromDb = funcionarioRepository.findAll();

		if (funcionarioFromDb.isEmpty()) {
			return "errado";
		}

		model.addAttribute("listfuncionario", funcionarioRepository.findAll());

		return "/funcionario/listafuncionarios";
	}
	
	@PostMapping(value = "/funcionario")
	@Transactional
	public ResponseEntity<Object> addfuncionario(@RequestBody @Valid FuncionarioTemp funcionarioTemp) {

		System.out.println("Nome: " + funcionarioTemp.getNome());
		System.out.println("CPF: " + funcionarioTemp.getCpf());
		System.out.println("Email: " + funcionarioTemp.getEmail());
		System.out.println("Telefone: " + funcionarioTemp.getTelefone());
		System.out.println("Salario: " + funcionarioTemp.getSalario());

		boolean existeCpf = funcionarioRepository.existsByCpf(funcionarioTemp.getCpf());

		if (existeCpf) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
		}

		Funcionario funcionario = funcionarioTemp.toModel();

		funcionarioRepository.save(funcionario);

		return ResponseEntity.created(null).body("funcionario cadastrado com sucesso");

	}

*/




	@Autowired
	FuncionarioRepository funcionarioRepository;

	

	@PostMapping(value = "/funcionario")
	@Transactional
	public ResponseEntity<Object> addfuncionario(@RequestBody @Valid FuncionarioTemp funcionarioTemp) {

		System.out.println("Nome: " + funcionarioTemp.getNome());
		System.out.println("CPF: " + funcionarioTemp.getCpf());
		System.out.println("Email: " + funcionarioTemp.getEmail());
		System.out.println("Telefone: " + funcionarioTemp.getTelefone());
		System.out.println("Salario: " + funcionarioTemp.getSalario());

		boolean existeCpf = funcionarioRepository.existsByCpf(funcionarioTemp.getCpf());

		if (existeCpf) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
		}

		Funcionario funcionario = funcionarioTemp.toModel();

		funcionarioRepository.save(funcionario);

		return ResponseEntity.created(null).body("funcionario cadastrado com sucesso");

	}

	@GetMapping(value = "/funcionario")
	public List<FuncionarioResponse> listaFuncionario() {

		List<FuncionarioResponse> funcionarioResponse = new ArrayList<>();

		List<Funcionario> funcionarioFromDb = funcionarioRepository.findAll();

		if (funcionarioFromDb.isEmpty()) {
			return null;
		}

		for (Funcionario funcionario : funcionarioFromDb) {
			funcionarioResponse.add(new FuncionarioResponse(funcionario.id, funcionario.nome));
		}

		return funcionarioResponse;
	}

	@GetMapping(value = "/funcionario/{idFuncionario}")
	public ResponseEntity<Object> listaDetalhesFuncionario(@Valid @NotNull @PathVariable long idFuncionario) {

		Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(idFuncionario);

		if (funcionarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Funcionario funcionarioFromDB = funcionarioOpt.get();

		ListaDetalhesFuncionario detalhesFuncionario = new ListaDetalhesFuncionario(funcionarioFromDB.cpf,
				funcionarioFromDB.nome, funcionarioFromDB.telefone, funcionarioFromDB.email, funcionarioFromDB.salario);

		return ResponseEntity.ok(detalhesFuncionario);

	}

	@DeleteMapping(value = "/funcionario/{idFuncionario}")
	public ResponseEntity<Object> removeFuncionario(@Valid @NotNull @PathVariable long idFuncionario) {

		Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(idFuncionario);

		if (funcionarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Funcionario funcionarioFromDB = funcionarioOpt.get();

		funcionarioRepository.delete(funcionarioFromDB);

		return ResponseEntity.ok().body("deletado com sucesso");

	}

	@PutMapping(value = "/funcionario/{idFuncionario}")
	@Transactional
	public ResponseEntity<Object> alteraFuncionario(@Valid @NotNull @PathVariable long idFuncionario,
			@RequestBody FuncionarioAlterna funcionarioAlterna) {

		Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(idFuncionario);

		if (funcionarioOpt.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			funcionarioAlterna.alteraDados(funcionarioOpt.get());

			return ResponseEntity.status(HttpStatus.OK).body("funcionario alterado com sucesso");
		}
	}
 
}
