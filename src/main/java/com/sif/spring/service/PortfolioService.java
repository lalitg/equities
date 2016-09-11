package com.sif.spring.service;

import java.util.List;

import com.sif.spring.model.Portfolio;



public interface PortfolioService {
	
	//Portfolio findById(long id);
	
	Portfolio findByName(String name);
	
	void savePortfolio(Portfolio Portfolio);
	
	void updatePortfolio(Portfolio Portfolio);
	
	void deletePortfolioByName(String name);

	List<Portfolio> findAllPortfolios(); 
	
	void deleteAllPortfolios();
	
	public boolean isPortfolioExist(Portfolio Portfolio);
	
}
