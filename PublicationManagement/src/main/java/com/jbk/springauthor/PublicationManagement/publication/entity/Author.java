package com.jbk.springauthor.PublicationManagement.publication.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.domain.EntityScan;



@Entity
@Table(name="author")
public class Author{


    // Fields    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="aid")
     private Integer aid;
	@Column(name="author_name")
     private String author_name;
     
	 @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "author_publication", 
	             joinColumns = { @JoinColumn(name = "aid") }, 
	             inverseJoinColumns = { @JoinColumn(name = "pid") })
	    private List<Publication> publications = new ArrayList<Publication>();
	
	
	

    // Constructors

    /** default constructor */
    public Author() {
    }

	/** minimal constructor */
    public Author(String author_name) {
  
        this.author_name = author_name;
    }

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + (int) (aid ^ (aid >>> 32)); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (!(obj instanceof Author)) return false;
	 * Author other = (Author) obj; if (aid != other.aid) return false; return true;
	 * }
	 */
		@Override
		public String toString() {
			return "Author [aid=" + aid + ", author_name=" + author_name + ", publications=" + publications + "]";
		}

   




}