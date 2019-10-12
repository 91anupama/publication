package com.jbk.springauthor.PublicationManagement.publication.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="publication")
public class Publication  implements java.io.Serializable {


    // Fields    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
     private Integer pid;
	@Column(name="title")
     private String title;
	
	@Column(name="pyear")
     private String pyear;
	
	@Column(name="genre")
     private String genre;
	@Column(name="hero")
     private String hero;
	@Column(name="type_maz")
     private String type_maz;
	@Column(name="type_pub")
     private String type_pub;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "author_publication", joinColumns = { @JoinColumn(name = "pid") }, inverseJoinColumns = {
			@JoinColumn(name = "aid") })
	private List<Author> authors = new ArrayList<Author>();
	
	public Publication() {
		super();
		
	}
	

	
	public Publication(String title, String pyear, String genre, String hero, String type_maz, String type_pub,
			List<Author> authors) {
		super();
		this.title = title;
		this.pyear = pyear;
		this.genre = genre;
		this.hero = hero;
		this.type_maz = type_maz;
		this.type_pub = type_pub;
		this.authors = authors;
	}



	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPyear() {
		return pyear;
	}


	public void setPyear(String pyear) {
		this.pyear = pyear;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getHero() {
		return hero;
	}


	public void setHero(String hero) {
		this.hero = hero;
	}


	public String getType_maz() {
		return type_maz;
	}


	public void setType_maz(String type_maz) {
		this.type_maz = type_maz;
	}


	public String getType_pub() {
		return type_pub;
	}


	public void setType_pub(String type_pub) {
		this.type_pub = type_pub;
	}



	public List<Author> getAuthors() {
		return authors;
	}



	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}



	@Override
	public String toString() {
		return "Publication [pid=" + pid + ", title=" + title + ", pyear=" + pyear + ", genre=" + genre + ", hero="
				+ hero + ", type_maz=" + type_maz + ", type_pub=" + type_pub + ", authors=" + authors + "]";
	}


	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + (int) (pid ^ (pid >>> 32)); result = prime * result
	 * + ((title == null) ? 0 : title.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (!(obj instanceof Publication)) return
	 * false; Publication other = (Publication) obj; if (pid != other.pid) return
	 * false; if (title == null) { if (other.title != null) return false; } else if
	 * (!title.equals(other.title)) return false; return true; }
	 */
	
    
    
}