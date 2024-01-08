package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.pojos.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<Team> getTeamDetails() {
		List<Team> teams = null;
		// 1. get session from SF
		String jpql = "select new pojos.Team(id,abbreviation) from Team t";
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return teams;
	}

	@Override
	public Team getSelectedTeamDetails(Integer teamId) {
		Team team=null;
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin a tx
		Transaction tx = session.beginTransaction();
		try {
			team=session.get(Team.class, teamId);
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return team;
	}

}
