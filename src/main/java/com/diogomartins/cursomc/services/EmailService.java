package com.diogomartins.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.diogomartins.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
