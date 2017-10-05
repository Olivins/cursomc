package com.diogomartins.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.diogomartins.cursomc.domain.Categoria;
import com.diogomartins.cursomc.repositories.CategoriaRepository;
import com.diogomartins.cursomc.services.exception.DataIntegrityException;
import com.diogomartins.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		
		if(obj == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
					", Tipo: " + Categoria.class.getName());
			
		}
		return obj;
	}
	
	public void insert(Categoria obj) {
		obj.setId(null);
		repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		
		return repo.save(obj);
	}
	public void delete(Integer id) {
		 	find(id);
		 	try {
		 		repo.delete(id);
		 	}
		 	catch (DataIntegrityViolationException e) {
		 		throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		 	}
		 }
}
