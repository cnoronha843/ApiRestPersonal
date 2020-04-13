package br.com.PersonalSpringMVC.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.PersonalSpringMVC.model.service.AlunoService;
import br.com.PersonalSpringMVC.negocio.Aluno;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	
	
	@RequestMapping
	public List<Aluno> obterLista(){
		return service.obterLista();
	}
	
	@RequestMapping("{id}")
	public Optional<Aluno> obterPorId(@PathVariable Integer id) {
		return service.obterPorId(id);
	}
	
	@PostMapping
	public void incluir(@RequestBody Aluno aluno) {
		service.incluir(aluno);
	}
	
	@DeleteMapping("{id}")
	public void excluir(@PathVariable Integer id) {
		service.excluir(id);
	}

	public AlunoService getService() {
		return service;
	}
	public void setService(AlunoService service) {
		this.service = service;
	}
}