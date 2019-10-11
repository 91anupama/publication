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
public class AuthorControllerwithView {

	@Autowired
	private AuthorServiceImpl authorService;



	@GetMapping(value = {"/", "/home", "/index"})
	public ModelAndView getAuthors() {
		ModelAndView mav = new ModelAndView("authorList");
		List<Author> list = authorService.findAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/openAuthorView")
	public ModelAndView openAuthorAddView() {
		ModelAndView mav = new ModelAndView("authorsAdd");
		mav.addObject("author", new Author());
		return mav;
	}
	
	@PostMapping("/authorcreate")
	public ModelAndView  createAuthor(@ModelAttribute ("author") Author author) {
	   
		ModelAndView mav = new ModelAndView("authorsList");
		authorService.save(author);
		List<Author> list = authorService.findAll();
		mav.addObject("list", list);
		return mav;
	}
	
	
	//To update Author
		@PutMapping("/authorupdate")
		public Author updateAuthor(@RequestBody Author author) {
			return author;
		}
		
		
		@RequestMapping("/author/{aid}")
		public ModelAndView findById(@PathVariable("aid") int aid) {
			ModelAndView mav = new ModelAndView("authorsAdd");
			Author author = authorService.findById(aid);
			if(author == null) {
				throw new RuntimeException("Author not found"+aid);
			}
			mav.addObject("author", author);
			return mav;
		}
		
		//to Delete Author
		
		@DeleteMapping("/authordelete/{aid}")
		public ModelAndView  deleteAuthor(@PathVariable int aid) {
			ModelAndView mav = new ModelAndView("authorsList");
			authorService.deleteById(aid);
			List<Author> list = authorService.findAll();
			mav.addObject("list", list);
			return mav;

		}

}