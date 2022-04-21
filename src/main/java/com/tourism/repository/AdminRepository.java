package com.tourism.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourism.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

}
