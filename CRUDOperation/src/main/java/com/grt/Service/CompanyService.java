package com.grt.Service;

import java.util.List;

import com.grt.model.Company;

public interface CompanyService {
	Company saveCompany(Company company);
	List<Company> getCompany();
	Company getCompanyById(long id);
	Company updateCompany(Company company);
	void deleteCompany(long id);
}
