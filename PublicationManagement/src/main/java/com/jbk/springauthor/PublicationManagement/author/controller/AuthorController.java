package com.jbk.springauthor.PublicationManagement.author.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.author.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;



	@GetMapping(value = {"/all"})
	public List<Author> getAuthors() {
		List<Author> list = authorService.findAll();
		return list;
	}
	
	
		@PostMapping("/authorcreate")
	public void createAuthor(@RequestBody Author author) {
		authorService.save(author);
	
	}
	
	
		@PostMapping("/authorupdate/{aid}")
		public void updateAuthor(@RequestBody Author author,@PathVariable int aid) {
			authorService.saveOrUpdate(author);
		}
		
		
		@GetMapping("/findauthor/{aid}")
		public Author  findById(@PathVariable int aid) {
			Author author = authorService.findById(aid);
			if(author == null) {
				throw new RuntimeException("Author not found"+aid);
			}
		
			return author;
		}
		
		@DeleteMapping("/deleteauthor/{aid}")
		public List<Author>  deleteAuthor(@PathVariable int aid) {
			authorService.deleteById(aid);
			List<Author> list = authorService.findAll();
			return list;

		}

}