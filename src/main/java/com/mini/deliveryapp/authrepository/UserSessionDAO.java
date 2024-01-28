package com.mini.deliveryapp.authrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteapp.authmodels.UserSession;


@Repository
public interface UserSessionDAO extends JpaRepository<UserSession, Integer> {
	
	public Optional<UserSession> findByUserId(Integer userId);
	
	public Optional<UserSession> findByUUID(String uuid);

}
