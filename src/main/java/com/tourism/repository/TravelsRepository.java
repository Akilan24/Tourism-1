package com.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.model.Travels;

public interface TravelsRepository extends JpaRepository<Travels, Integer> {

}
