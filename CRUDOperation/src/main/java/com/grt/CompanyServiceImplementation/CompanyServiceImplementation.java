package com.grt.CompanyServiceImplementation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.grt.Service.CompanyService;
import com.grt.model.Company;
import com.grt.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyServiceImplementation implements CompanyService{

	private final CompanyRepository companyRepos;
	
	@Override
	public Company saveCompany(Company company) {
		return companyRepos.save(company);
	}

	@Override
	public List<Company> getCompany() {
		return companyRepos.findAll();
		}

	@Override
	public Company updateCompany(Company company) {
		companyRepos.findById(company.getId()).orElseThrow(()-> new RuntimeException("Id not found"));
		return companyRepos.save(company);
	}

	@Override
	public void deleteCompany(long id) {
		companyRepos.deleteById(id);
		
	}

	@Override
	public Company getCompanyById(long id) {
		return companyRepos.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		
	}
	
	

}
