package com.crb.DemoCRB.service;

import java.util.List;

import com.crb.DemoCRB.model.Pack;

public interface PackService {
	Pack findById(long id);
	
	Pack findByNumber(String number);
	
	void savePack(Pack pack);
	
	void updatePack(Pack pack);
	
	void deletePackById(long id);

	List<Pack> findAllPacks(); 
	
	void deleteAllPacks();
	
	public boolean isPackExist(Pack pack);
}
