package com.portal.portalbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.portalbackend.Client;
import com.portal.portalbackend.dao.ClientDao;

@Repository("clientDao")
@Transactional
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addClient(Client client) {
		try {
			sessionFactory.getCurrentSession().save(client);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean deleteClient(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateClient(Client client) {
		try {
			sessionFactory.getCurrentSession().update(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Client getClient(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Client.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Client> retrieveAllClients() {
		try {

			return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;

		}
	}

}
