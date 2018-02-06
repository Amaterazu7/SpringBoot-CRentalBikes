package com.crb.DemoCRB.repository;

import org.springframework.data.repository.CrudRepository;

import com.crb.DemoCRB.model.Pack;

public interface PackRepository extends CrudRepository<Pack, Long> {

	Pack findByNumber(String number);
}