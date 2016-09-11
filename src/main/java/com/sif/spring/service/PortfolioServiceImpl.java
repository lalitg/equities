package com.sif.spring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sif.spring.model.Portfolio;

@Service("PortfolioService")
@Transactional
public class PortfolioServiceImpl implements PortfolioService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Portfolio> Portfolios;
	
	static{
		Portfolios= populateDummyPortfolios();
	}

	public List<Portfolio> findAllPortfolios() {
		return Portfolios;
	}
		
	public Portfolio findByName(String name) {
		for(Portfolio Portfolio : Portfolios){
			if(Portfolio.getCompanyName().equalsIgnoreCase(name)){
				return Portfolio;
			}
		}
		return null;
	}
	
	public void savePortfolio(Portfolio Portfolio) {
		Portfolios.add(Portfolio);
	}

	public void updatePortfolio(Portfolio Portfolio) {
		int index = Portfolios.indexOf(Portfolio);
		System.out.println("index is "+index);
		Portfolios.set(index, Portfolio);
	}

	public void deletePortfolioByName(String name) {
		
		for (Iterator<Portfolio> iterator = Portfolios.iterator(); iterator.hasNext(); ) {
		    Portfolio Portfolio = iterator.next();
		    if (Portfolio.getCompanyName().equals(name)) {
		        iterator.remove();
		    }
		}
	}

	public boolean isPortfolioExist(Portfolio portfolio) {
		return findByName(portfolio.getCompanyName())!=null;
	}

	private static List<Portfolio> populateDummyPortfolios(){
		List<Portfolio> Portfolios = new ArrayList<Portfolio>();
		Portfolios.add(new Portfolio("1","20","30", "70000"));
		Portfolios.add(new Portfolio("2","30","40", "50000"));
		Portfolios.add(new Portfolio("3","40","45", "30000"));
		Portfolios.add(new Portfolio("4","50","50", "40000"));
		return Portfolios;
	}

	public void deleteAllPortfolios() {
		Portfolios.clear();
	}

}
