package com.poc.model;

public class AuctionBid {

	private Integer id;
	private Auction auction;
	private SystemUser user;
	private Integer bid;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	public SystemUser getUser() {
		return user;
	}
	
	public void setUser(SystemUser user) {
		this.user = user;
	}
	
	public Integer getBid() {
		return bid;
	}
	
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AuctionBid other = (AuctionBid) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
