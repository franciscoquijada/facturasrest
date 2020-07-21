package com.projecto.finalspringboot.service;

import com.projecto.finalspringboot.model.ResetToken;

public interface IResetTokenService{

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
