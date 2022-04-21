package com.tourism.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tourism.model.TPackages;

@Service
public interface TPackagesService {

	void saveTPackages(TPackages t);
	TPackages updateTPackages(TPackages t,int tpid);
	TPackages deleteTPackagesById(int tpid);
	TPackages getTPackagesById(int tpid);
	List<TPackages> fetchTPackagesList();
}
