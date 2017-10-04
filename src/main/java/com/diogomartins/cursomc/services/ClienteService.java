package com.diogomartins.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogomartins.cursomc.domain.Cliente;
import com.diogomartins.cursomc.repositories.ClienteRepository;
import com.diogomartins.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Cliente obj = repo.findOne(id);
		
		if(obj == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
					", Tipo: " + Cliente.class.getName());
			
		}
		return obj;
	}
}
