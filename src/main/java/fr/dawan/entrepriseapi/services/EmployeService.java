package fr.dawan.entrepriseapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.dawan.entrepriseapi.entities.Employe;
import fr.dawan.entrepriseapi.entities.Login;
import fr.dawan.entrepriseapi.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepository;
	
	public Employe save(Employe e) {
		return employeRepository.save(e);
	}
	
	public void delete(Employe e) {
		employeRepository.delete(e);
	}
	
	public void deleteById(Long id) {
		employeRepository.deleteById(id);
	}
	
	public List<Employe> findAll() {
		return employeRepository.findAll();
	}
	
	public Optional<Employe> findById(Long id) {
		return employeRepository.findById(id);
	}
	
	public Employe findByLogin(Login credentials) {
		String login = credentials.getLogin();
		String password = credentials.getPassword();
		return employeRepository.findByLogin(login, password);
	}
	
//	public void ex(Long id) {
//		return employeRepository.;
//	}
}
