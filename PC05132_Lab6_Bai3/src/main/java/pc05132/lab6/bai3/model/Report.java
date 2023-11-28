package pc05132.lab6.bai3.model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Report {
	@Id
	private Serializable group;
	private Long likes;
	private Date newest;
	private Date oldest;
	
	
	public Report(Serializable group, Long likes, Date newest, Date oldest) {
		super();
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldest = oldest;
	}
	public Serializable getGroup() {
		return group;
	}
	public void setGroup(Serializable group) {
		this.group = group;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public Date getNewest() {
		return newest;
	}
	public void setNewest(Date newest) {
		this.newest = newest;
	}
	public Date getOldest() {
		return oldest;
	}
	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}
	
	
}
