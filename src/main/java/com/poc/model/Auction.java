package com.poc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Auction {

	@Id
	private Integer id;
	
	@Column
	private String title;
	
	@Column(name="CURRENT_BID")
	private Integer currentBid;
	
	@Transient
	private List<AuctionBid> bids;
	
	public Auction() {
		bids = new ArrayList<AuctionBid>();
	}
	
	public Integer getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Integer currentBid) {
		this.currentBid = currentBid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<AuctionBid> getBids() {
		return bids;
	}
	
	public void setBids(List<AuctionBid> bids) {
		this.bids = bids;
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
		Auction other = (Auction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
