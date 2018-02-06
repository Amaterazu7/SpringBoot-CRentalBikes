package com.crb.DemoCRB.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crb.DemoCRB.model.Pack;
import com.crb.DemoCRB.repository.PackRepository;


@Service("packService")
@Transactional
public class PackServiceImpl implements PackService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Pack> packs;
	
	@Autowired
	private PackRepository packRepository;
	
	public List<Pack> findAllPacks() {
		return (List<Pack>) packRepository.findAll();
	}
		
	@Override
	public Pack findById(long id) {
		return packRepository.findOne(id);
	}

	@Override
	public Pack findByNumber(String number) {
		return packRepository.findByNumber(number);
	}

	@Override
	public void savePack(Pack pack) {
		packRepository.save(pack);
	}

	@Override
	public void updatePack(Pack pack) {
		packRepository.save(pack);
	}

	@Override
	public void deletePackById(long id) {
		packRepository.delete(id);
	}

	@Override
	public boolean isPackExist(Pack pack) {
		return findByNumber(pack.getNumber())!=null;
	}
	
	@Override
	public void deleteAllPacks() {
		packRepository.deleteAll();
	}

}
