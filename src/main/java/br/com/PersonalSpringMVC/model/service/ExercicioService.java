package br.com.PersonalSpringMVC.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.PersonalSpringMVC.model.repository.IExercicioRepository;
import br.com.PersonalSpringMVC.negocio.Exercicio;

@Service
public class ExercicioService {

	@Autowired
	private IExercicioRepository repository;

	public List<Exercicio> obterLista(){
		return (List<Exercicio>)repository.findAll();
	}
	
	public Optional<Exercicio> obterPorId(Integer id) {
		return repository.findById(id);
	}
	
	public void incluir(Exercicio exercicio) {
		repository.save(exercicio);
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}

	public IExercicioRepository getRepository() {
		return repository;
	}
	public void setRepository(IExercicioRepository repository) {
		this.repository = repository;
	}
}