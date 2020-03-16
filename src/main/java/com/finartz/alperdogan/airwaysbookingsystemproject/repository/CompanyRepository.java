package com.finartz.alperdogan.airwaysbookingsystemproject.repository;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
}
