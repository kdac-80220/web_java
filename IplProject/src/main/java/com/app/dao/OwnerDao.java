package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.pojos.Owner;
import com.app.pojos.Player;
import com.app.pojos.Team;

public class OwnerDao {
	public String addOwner(Owner owner) {
		String mesg="Adding new owner failed!!!!!!!!";
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			//get team from it's id
			session.persist(owner);
			tx.commit();
			mesg="Added";
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}
}
