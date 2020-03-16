package com.finartz.alperdogan.airwaysbookingsystemproject.service;

import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {

  public List<Company> getCompanies();
  public Company createCompany(Company company);
  public Optional<Company> findCompanyById(Long id);
  public List<Company> findCompanyByName(String companyName);
}
