package com.jbk.springauthor.PublicationManagement.author.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jbk.springauthor.PublicationManagement.author.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
