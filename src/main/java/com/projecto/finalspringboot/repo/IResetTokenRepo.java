package com.projecto.finalspringboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.finalspringboot.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
