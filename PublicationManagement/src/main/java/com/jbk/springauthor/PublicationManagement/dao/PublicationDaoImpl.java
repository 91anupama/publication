package com.jbk.springauthor.PublicationManagement.publication.dao;

import java.util.List;

import javax.persistence.EntityManager;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.springauthor.PublicationManagement.author.entity.Author;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

@Repository
public class PublicationDaoImpl implements PublicationDaoInterface{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Publication> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Publication> query = currentSession.createQuery("from publication", Publication.class);
		List<Publication> list = query.getResultList();
		return list;
	}

	@Override
	public Publication findById(int pid) {
		Session currentSession = entityManager.unwrap(Session.class);
		Publication pubObj = currentSession.get(Publication.class, pid);
		return pubObj;
	}

	@Override
	public void save(Publication publication) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(publication);
		
	}

	@Override
	public void saveorUpdate(Publication publication) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(publication);
		
	}
	@Override
	public void deleteById(int pid) {
		// TODO Auto-generated method stub
		
		Session currentSession = entityManager.unwrap(Session.class);
		Publication publication = currentSession.get(Publication.class, pid);
		currentSession.delete(publication);
		
	}

	public void updateById(int pid) {
		Session currentSession=entityManager.unwrap(Session.class);
		Publication publication = currentSession.get(Publication.class, pid);
		currentSession.update(pid);
	}

}
