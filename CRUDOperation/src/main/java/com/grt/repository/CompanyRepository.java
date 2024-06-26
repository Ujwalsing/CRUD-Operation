package com.grt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grt.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
