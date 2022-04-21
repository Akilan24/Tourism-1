package com.tourism.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.model.TPackages;
import com.tourism.repository.TPackagesRepository;

@Service
public class TPackagesServiceImpl implements TPackagesService{
    @Autowired
    TPackagesRepository repo;
    
	@Override
	public void saveTPackages(TPackages t) {
		repo.save(t);
		
	}

	@Override
	public List<TPackages> fetchTPackagesList() {
		List<TPackages> list=repo.findAll();
		return list;
	}

	@Override
	public TPackages updateTPackages(TPackages t, int tpid) {
		TPackages tp=repo.getById(tpid);
		tp.setRoute(t.getRoute());
		tp.setStartingdate(t.getStartingdate());
		tp.setEndingdate(t.getEndingdate());
		tp.setBudgetperperson(t.getBudgetperperson());
		tp.setDuration(t.getDuration());
		tp.setTravelsid(t.getTravelsid());
		return tp;
	}

	@Override
	public TPackages deleteTPackagesById(int tpid) {
		TPackages tp=repo.getById(tpid);
		repo.deleteById(tpid);
		return tp;
	}

	@Override
	public TPackages getTPackagesById(int tpid) {
		TPackages tp=repo.getById(tpid);
		return tp;
	}

}
