package com.mini.deliveryapp.authrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteapp.authmodels.LogInModel;


@Repository
public interface LogInModelDAO extends JpaRepository<LogInModel, Integer>{

}
