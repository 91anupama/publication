package com.jbk.springauthor.PublicationManagement.publication.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.springauthor.PublicationManagement.publication.dao.PublicationDao;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

@Repository
public class PublicationDaoImpl implements PublicationDao {


	@Autowired
	EntityManager entityManager;

	@Override
	public List<Publication> findAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Publication> query = session.createQuery("from Publication", Publication.class);
		List<Publication> publications = query.getResultList();
		return publications;
	}


	@Override
	public Publication findById(int pid) {
		Session session = entityManager.unwrap(Session.class);
		Publication publication = session.get(Publication.class, pid);
		return publication;
	}

	@Override
	public void save(Publication publication) {
		Session session = entityManager.unwrap(Session.class);
		session.save(publication);

	}

	@Override
	public void deleteById(int pid) {
		Session session = entityManager.unwrap(Session.class);
		// delete object with primary key
//		Query query = session.createQuery("delete from publication where id=:pid");
//		query.setParameter("pid", pid);
//		return query.executeUpdate();
		Publication publication = session.get(Publication.class, pid);
		session.delete(publication);
	}

	@Override
	public void saveorupdate(Publication publication) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(publication);
	}

}
