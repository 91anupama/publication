package com.jbk.springauthor.PublicationManagement.author.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jbk.springauthor.PublicationManagement.author.dao.AuthorRepository;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

public List<Author> getAllAuthors() {
	// TODO Auto-generated method stub
	
	
	return authorRepository.findAll();
	
}

public Author save(Author author) {
	// TODO Auto-generated method stub
	return authorRepository.saveAndFlush(author);
}


}
