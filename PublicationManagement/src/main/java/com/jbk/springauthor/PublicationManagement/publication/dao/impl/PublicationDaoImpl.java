package com.jbk.springauthor.PublicationManagement.publication.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.springauthor.PublicationManagement.author.dao.impl.AuthorDaoImpl;
import com.jbk.springauthor.PublicationManagement.publication.dao.PublicationDao;
import com.jbk.springauthor.PublicationManagement.publication.entity.Publication;

@Repository
public class PublicationDaoImpl implements PublicationDao {
	private static  final Logger LOGGER =LoggerFactory.getLogger(PublicationDaoImpl.class);

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Publication> findAll() {
		LOGGER.info("Inside Publication FindAll");
		Session session = entityManager.unwrap(Session.class);
		Query<Publication> query = session.createQuery("from Publication", Publication.class);
		List<Publication> publications = query.getResultList();
		return publications;
	}

	@Override
	public Publication findById(int pid) {
		LOGGER.info("Inside Publication findById");
		Session session = entityManager.unwrap(Session.class);
		Publication publication = session.get(Publication.class, pid);
		return publication;
	}

	@Override
	public void save(Publication publication) {
		LOGGER.info("Inside Publication save");
		Session session = entityManager.unwrap(Session.class);
		session.save(publication);

	}

	@Override
	public void deleteById(int pid) {
		LOGGER.info("Inside Publication deleteById");
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
		LOGGER.info("Inside Publication saveorupdate");
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(publication);
	}


	@SuppressWarnings("unchecked")

	@Override
	public List<Publication> getPublicationWithAuthor(String author_name) {
		Session session = entityManager.unwrap(Session.class);
		String[] authors = { author_name };
		String hql = "select distinct p from Publication p " + "join p.authors a "
				+ "where a.author_name in (:authors)";

		@SuppressWarnings("rawtypes")

		Query query = session.createQuery(hql);
		query.setParameterList("authors", authors);
		List<Publication> publications = query.list();
		return publications;
		/*
		 * Session session = entityManager.unwrap(Session.class);
		 * 
		 * @SuppressWarnings("unchecked") String
		 * sql="select * from Publication p join p.authors a where p.aid = :aid";
		 * Query<Publication> query = session.createSQLQuery(sql);
		 * query.setInteger("aid", 1); List publications = query.list(); return
		 * publications;
		 */
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Publication> getPublicationWithAuthorType_p(String author_name, String type_pub) {
		Session session = entityManager.unwrap(Session.class);
		String[] authors = { author_name };
		String hql = "select distinct p from Publication p " + "join p.authors a "
				+ "where a.author_name in (:authors) and p.type_pub = :type_pub";
		Query query = session.createQuery(hql);
		query.setParameterList("authors", authors);
		query.setParameter("type_pub", type_pub);
		List<Publication> publications = query.list();
		return publications;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Publication> getPublicationWithAuthorType_p_sub_type(String author_name, String type_pub,
			String sub_type,String sub_type_val) {

		String hero = "hero";
		String genre = "genre";
		String type_maz = "type_maz";
		List<Publication> publications=null;
		if (hero.equals(sub_type)) {
			Session session = entityManager.unwrap(Session.class);
			String[] authors = { author_name };
			String hql = "select distinct p from Publication p " + "join p.authors a "
					+ "where a.author_name in (:authors) and p.type_pub = :type_pub and p.hero = :sub_type_val";
			Query query = session.createQuery(hql);
			query.setParameterList("authors", authors);
			query.setParameter("type_pub", type_pub);
			query.setParameter("sub_type_val", sub_type_val);
			publications = query.list();

		}

		if (genre.equals(sub_type)) {
			Session session = entityManager.unwrap(Session.class);
			String[] authors = { author_name };
			String hql = "select distinct p from Publication p " + "join p.authors a "
					+ "where a.author_name in (:authors) and p.type_pub = :type_pub and p.genre = :sub_type";
			Query query = session.createQuery(hql);
			query.setParameterList("authors", authors);
			query.setParameter("type_pub", type_pub);
			query.setParameter("sub_type", genre);
			publications = query.list();

		}
		if (type_maz.equals(sub_type)) {
			Session session = entityManager.unwrap(Session.class);
			String[] authors = { author_name };
			String hql = "select distinct p from Publication p " + "join p.authors a "
					+ "where a.author_name in (:authors) and p.type_pub = :type_pub and p.type_maz = :sub_type";
			Query query = session.createQuery(hql);
			query.setParameterList("authors", authors);
			query.setParameter("type_pub", type_pub);
			query.setParameter("sub_type", type_maz);
			publications = query.list();

		}
		return publications;

	}


}
