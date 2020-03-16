package com.finartz.alperdogan.airwaysbookingsystemproject.impl;

import com.finartz.alperdogan.airwaysbookingsystemproject.DAO.CompanyDAO;
import com.finartz.alperdogan.airwaysbookingsystemproject.entity.Company;
import com.finartz.alperdogan.airwaysbookingsystemproject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAO;

    @Override
    public List<Company> getCompanies(){
        return companyDAO.getCompanies();
    }

    @Override
    public Company createCompany(Company company){
        return companyDAO.create(company);
    }

    @Override
    public Optional<Company> findCompanyById(Long id) {
        return companyDAO.findById(id);
    }

    @Override
    public List<Company> findCompanyByName(String companyName) {
        return companyDAO.findByName(companyName);
    }
}
