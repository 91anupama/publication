package com.jbk.springauthor.PublicationManagement.publication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;
import com.jbk.springauthor.PublicationManagement.publication.service.PublicationService;

@RestController
@RequestMapping("/publication")
public class PublicationController {


	@Autowired
	private PublicationService publicationService;

	
	@GetMapping("/all")
	public List<Publication> findAll() {
		return publicationService.findAll();
	}

	@GetMapping("/getpublication/{pid}")
	public Publication getPublicationByid(@PathVariable int pid) {
		Publication publication = publicationService.findById(pid);
		if (publication == null) {
			throw new RuntimeException("Publication not found" + pid);
		}
		return publication;
	}


	@PostMapping("/addpublication")
	public Publication createPublication(@RequestBody Publication publication) {
		publication.setPid(0);
		publicationService.save(publication);

		return publication;
	}


	@PostMapping("/updatepublication/{pid}")
	public Publication updatePublication(@RequestBody Publication publication,@PathVariable int pid) {
		publicationService.saveorupdate(publication);
		return publication;
	}


	@DeleteMapping("/deletepublication/{pid}")
	public void deletePublication(@PathVariable int pid) {
		publicationService.deleteById(pid);
		

	}

}