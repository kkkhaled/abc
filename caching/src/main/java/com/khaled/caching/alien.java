package com.khaled.caching;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Alien_name")
@Cacheable
@Cache(usage =CacheConcurrencyStrategy.READ_ONLY)
public class alien {
	@Id
	private int aid;
	private String aname;
	private String acolor;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAcolor() {
		return acolor;
	}
	public void setAcolor(String acolor) {
		this.acolor = acolor;
	}
	@Override
	public String toString() {
		return "alien [aid=" + aid + ", aname=" + aname + ", acolor=" + acolor + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
