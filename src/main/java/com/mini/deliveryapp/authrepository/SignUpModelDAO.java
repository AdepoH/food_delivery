package com.mini.deliveryapp.authrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteapp.authmodels.SignUpModel;

@Repository
public interface SignUpModelDAO extends JpaRepository<SignUpModel, Integer> {
	
	public Optional<SignUpModel> findByUserName(String userName);

}
