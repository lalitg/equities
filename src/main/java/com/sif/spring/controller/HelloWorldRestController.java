package com.sif.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sif.spring.model.Portfolio;
import com.sif.spring.service.PortfolioService;

@RestController
public class HelloWorldRestController {

	@Autowired
	PortfolioService portfolioService;  //Service which will do all data retrieval/manipulation work

	
	//-------------------Retrieve All Portfolios--------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listAllPortfolios() {
		List<Portfolio> portfolios = portfolioService.findAllPortfolios();
		if(portfolios == null || portfolios.isEmpty()){
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		Map<String,Object> resp = new HashMap<String, Object>();
		resp.put("page", "1");
		resp.put("per_page", "3");
		resp.put("total", "12");
		resp.put("total_pages", "4");
		resp.put("data", portfolios);
		return new ResponseEntity<Map<String,Object>>(resp, HttpStatus.OK);
	}


	//-------------------Retrieve Single Portfolio--------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String,Object>> getPortfolio(@PathVariable("companyName") String companyName) {
		System.out.println("Fetching Portfolio with companyName " + companyName);
		Portfolio portfolio = portfolioService.findByName(companyName);
		if (portfolio == null) {
			System.out.println("Portfolio with id " + companyName + " not found");
			return new ResponseEntity<Map<String,Object>>(HttpStatus.NOT_FOUND);
		}
		Map<String,Object> resp = new HashMap<String, Object>();
		resp.put("data", portfolio);
		return new ResponseEntity<Map<String,Object>>(resp, HttpStatus.OK);
	}

	
	
	//-------------------Create a Portfolio--------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPortfolio(@RequestBody Portfolio portfolio, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Portfolio " + portfolio.getCompanyName());
        System.out.println(portfolio);
		if (portfolioService.isPortfolioExist(portfolio)) {
			System.out.println("A Portfolio with name " + portfolio.getCompanyName() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		portfolioService.savePortfolio(portfolio);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/Portfolio/{companyName}").buildAndExpand(portfolio.getCompanyName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	//------------------- Update a Portfolio --------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/{companyName}", method = RequestMethod.PUT)
	public ResponseEntity<Portfolio> updatePortfolio(@PathVariable("companyName") String companyName, @RequestBody Portfolio portfolio) {
		System.out.println("Updating Portfolio " + companyName);
		
		Portfolio currentPortfolio = portfolioService.findByName(companyName);
		
		if (currentPortfolio==null) {
			System.out.println("Portfolio with companyName " + companyName + " not found");
			return new ResponseEntity<Portfolio>(HttpStatus.NOT_FOUND);
		}

		currentPortfolio.setInvestmentPrice(portfolio.getInvestmentPrice());
		currentPortfolio.setLivePrice(portfolio.getLivePrice());
		currentPortfolio.setQuantity(portfolio.getQuantity());
		
		portfolioService.updatePortfolio(currentPortfolio);
		return new ResponseEntity<Portfolio>(currentPortfolio, HttpStatus.OK);
	}

	//------------------- Delete a Portfolio --------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/{companyName}", method = RequestMethod.DELETE)
	public ResponseEntity<Portfolio> deletePortfolio(@PathVariable("companyName") String companyName) {
		System.out.println("Fetching & Deleting Portfolio with id " + companyName);

		Portfolio portfolio = portfolioService.findByName(companyName);
		System.out.println(portfolio);
		if (portfolio == null) {
			System.out.println("Unable to delete. Portfolio with companyName " + companyName + " not found");
			return new ResponseEntity<Portfolio>(HttpStatus.NOT_FOUND);
		}

		portfolioService.deletePortfolioByName(companyName);
		System.out.println(portfolioService.findAllPortfolios());
		return new ResponseEntity<Portfolio>(HttpStatus.NO_CONTENT);
	}

	
	//------------------- Delete All Portfolio --------------------------------------------------------
	
	@RequestMapping(value = "/portfolio/", method = RequestMethod.DELETE)
	public ResponseEntity<Portfolio> deleteAllPortfolios() {
		System.out.println("Deleting All Portfolios");

		portfolioService.deleteAllPortfolios();
		return new ResponseEntity<Portfolio>(HttpStatus.NO_CONTENT);
	}

}
