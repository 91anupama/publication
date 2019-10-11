package com.jbk.springauthor.PublicationManagement.author.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.author.service.AuthorServiceImpl;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorServiceImpl authorService;



	@GetMapping(value = {"/"})
	public List<Author> getAuthors() {
		List<Author> list = authorService.findAll();
		
		return list;
	}
	
	
		@PostMapping("/authorcreate")
	public void createAuthor(@RequestBody Author author) {
		authorService.save(author);
	
	}
	
	
	//To update Author
		@PutMapping("/authorupdate/{aid}")
		public void updateAuthor(@RequestBody Author author,@PathVariable int aid) {
			authorService.saveOrUpdate(author);
		}
		
		
		@GetMapping("/findAuthor/{aid}")
		public Author  findById(@PathVariable int aid) {
			Author author = authorService.findById(aid);
			if(author == null) {
				throw new RuntimeException("Author not found"+aid);
			}
		
			return author;
		}
		
		//to Delete Author
		
		@DeleteMapping("/deleteAuthor/{aid}")
		public List<Author>  deleteAuthor(@PathVariable int aid) {
			authorService.deleteById(aid);
			List<Author> list = authorService.findAll();
			return list;

		}

}