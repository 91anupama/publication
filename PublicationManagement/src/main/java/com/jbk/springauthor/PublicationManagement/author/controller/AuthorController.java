package com.jbk.springauthor.PublicationManagement.author.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springauthor.PublicationManagement.author.dao.AuthorRepository;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.author.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	/*
	 * @RequestMapping("/author") public List<Author> getAuthors(){ return
	 * authorService.getAllAuthors(); }
	 */
	/*
	 * @RequestMapping("/author") public String getAuthors(){ return "ABC"; }
	 */

	@GetMapping("/author")
	public List<Author> getAuthors() {
		return authorService.getAllAuthors();
	}
	
	@PostMapping("/authorpost")
	public Author createAuthor( @RequestBody Author author) {
	    return authorService.save(author);
	}

}