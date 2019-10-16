package com.jbk.springauthor.PublicationManagement.author.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.author.service.AuthorService;
import com.jbk.springauthor.PublicationManagement.exception.author.DBException.NoData;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	private AuthorService authorService;



	@GetMapping(value = {"/author/all"})

	public List<Author> getAuthors() {
		List<Author> list = authorService.findAll();
		return list;
	}
	
	
		@PostMapping("/author/create")
		public ResponseEntity<Author> createAuthor ( @Valid @RequestBody Author author)
		{
		   authorService.save(author);
		    return new ResponseEntity<Author>(author, HttpStatus.OK);
		}
		
	
		@PostMapping("/author/update/{aid}")
		public void updateAuthor(@RequestBody Author author,@PathVariable int aid) {
			authorService.saveOrUpdate(author);
		}
		
		
		@GetMapping("/author/findauthor/{aid}")
		public ResponseEntity<Author> findById (@PathVariable int aid) throws Exception
		{
		   Author author = authorService.findById(aid);
		     
		    if(author == null) {
		         throw new NoData("No data found for aid : " + aid);
		    }
		    return new ResponseEntity<Author>(author, HttpStatus.OK);
		}
		
		@DeleteMapping("/author/delete/{aid}")
		public List<Author>  deleteAuthor(@PathVariable int aid) {
			authorService.deleteById(aid);
			List<Author> list = authorService.findAll();
			return list;

		}

}