package com.jbk.springauthor.PublicationManagement.publication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;
import com.jbk.springauthor.PublicationManagement.publication.service.PublicationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PublicationController {


	@Autowired
	private PublicationService publicationService;

	
	@GetMapping("/publication/all")
	public List<Publication> findAll() {
		return publicationService.findAll();
	}

	@GetMapping("/publication/findpublication/{pid}")
	public Publication getPublicationByid(@PathVariable int pid) {
		Publication publication = publicationService.findById(pid);
		if (publication == null) {
			throw new RuntimeException("Publication not found" + pid);
		}
		return publication;
	}



	@PostMapping("/publication/add")

	public Publication createPublication(@RequestBody Publication publication) {		//publication.setPid(0);
		publicationService.save(publication);

		return publication;
	}


	@PostMapping("/publication/update/{pid}")
	public Publication updatePublication(@RequestBody Publication publication,@PathVariable int pid) {
		publicationService.saveorupdate(publication);
		return publication;
	}


	@DeleteMapping("/publication/delete/{pid}")
	public void deletePublication(@PathVariable int pid) {
		publicationService.deleteById(pid);
	}
	

	@PostMapping("/publication/getpublication_withauthor")
	public List<Publication> getPublicationWithAuthor(@RequestParam String author_name) {
		
		return publicationService.getPublicationWithAuthor(author_name);
	}
	
	@PostMapping("/publication/getpublication_with_author_type_p")
	public List<Publication> getPublicationWithAuthorType_p(@RequestParam String author_name,@RequestParam String type_pub) {
		
		return publicationService.getPublicationWithAuthorType_p(author_name,type_pub);
	}
	
	@PostMapping("/publication/getpublication_with_author_type_p_sub_type")
	public List<Publication> getPublicationWithAuthorType_p_Hero(@RequestParam String author_name,@RequestParam String type_pub,@RequestParam String sub_type,@RequestParam String sub_type_val) {
		
		return publicationService.getPublicationWithAuthorType_p_sub_type(author_name,type_pub,sub_type,sub_type_val);

	@PostMapping("/getpublicationwithauthor")
	public List<Publication> getPublicationWithAuthor(@RequestParam String author_name) {
		
		return publicationService.getPublicationWithAuthor(author_name);

	}

}