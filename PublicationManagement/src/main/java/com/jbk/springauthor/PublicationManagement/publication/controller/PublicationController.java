package com.jbk.springauthor.PublicationManagement.publication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jbk.springauthor.PublicationManagement.publication.entity.Author;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;
import com.jbk.springauthor.PublicationManagement.publication.service.PublicationServiceImpl;

@RestController
@RequestMapping("/publication")
public class PublicationController {

	// Dependecy Injection
	@Autowired
	private PublicationServiceImpl publicationService;

	// To get list of publications
	@GetMapping("/publication")
	public List<Publication> findAll() {
		return publicationService.findAll();
	}

	// Get Publication By Id
	@GetMapping("/publication/{pid}")
	public Publication getPublicationByid(@PathVariable int pid) {
		Publication publication = publicationService.findById(pid);
		if (publication == null) {
			throw new RuntimeException("Publication not found" + pid);
		}
		return publication;
	}

	// To add new publication
	@PostMapping("/publicationAdd")
	public Publication createPublication(@RequestBody Publication publication) {
		publication.setPid(0);
		publicationService.save(publication);

		return publication;
	}

	// To update Publication
	@PutMapping("/publicationupdate")
	public Publication updatePublication(@RequestBody Publication publication) {
		publicationService.saveorupdate(publication);
		return publication;
	}

	// to Delete Publication
	@DeleteMapping("/publicationdelete/{pid}")
	public void deletePublication(@PathVariable int pid) {
		publicationService.deleteById(pid);
		

	}

}