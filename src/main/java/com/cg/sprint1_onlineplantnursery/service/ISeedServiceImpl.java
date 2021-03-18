package com.cg.sprint1_onlineplantnursery.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.sprint1_onlineplantnursery.entity.Seed;
import com.cg.sprint1_onlineplantnursery.repository.ISeedRepository;

@Service
public class ISeedServiceImpl implements ISeedService{
	
	@Autowired
	private ISeedRepository repo;

	@Override
	public Seed addSeed(Seed seed) {
		return repo.save(seed);
	}

	@Override
	public Seed updateSeed(Seed seed) {
		return repo.save(seed);
	}

	@Override
	public Seed deleteSeed(Seed seed) {
		repo.delete(seed);
		return seed;
	}

	@Override
	public Optional<Seed> getSeed(int id) {
		return repo.findById(id);
	}

	@Override
	public Seed getSeed(String commonName) {
		return repo.findByCommonName(commonName);
	}

	@Override
	public List<Seed> getSeeds() {
		return repo.findAll();
	}

	@Override
	public List<Seed> getSeeds(String type) {
		return repo.findByType(type);
	}

}
