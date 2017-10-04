package com.diogomartins.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diogomartins.cursomc.domain.Pedido;
import com.diogomartins.cursomc.repositories.PedidoRepository;
import com.diogomartins.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		
		if(obj == null) {
			
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id + 
					", Tipo: " + Pedido.class.getName());
			
		}
		return obj;
	}
}
