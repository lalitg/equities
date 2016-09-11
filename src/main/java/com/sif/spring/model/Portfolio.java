package com.sif.spring.model;

public class Portfolio {

	private String companyName;
	
	private String investmentPrice;
	
	private String livePrice;
	
	private String quantity;

	public Portfolio(){
		companyName="";
	}
	
	public Portfolio(String companyName, String investmentPrice, String livePrice, String quantity){
		this.companyName = companyName;
		this.investmentPrice = investmentPrice;
		this.livePrice = livePrice;
		this.quantity = quantity;
	}
	
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getInvestmentPrice() {
		return investmentPrice;
	}

	public void setInvestmentPrice(String investmentPrice) {
		this.investmentPrice = investmentPrice;
	}

	public String getLivePrice() {
		return livePrice;
	}

	public void setLivePrice(String livePrice) {
		this.livePrice = livePrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (companyName.hashCode() ^ (companyName.hashCode() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		if (companyName != other.companyName)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{companyName=" + companyName + ", first_name=" + investmentPrice + ", last_name=" + livePrice
				+ ", avatar=" + quantity + "}";
	}


}
