package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class CandidateBean {

	private List<Candidate> candList;
	
	public CandidateBean()
	{
		this.candList = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandList() {
		return candList;
	}

	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void getCandidateList()
	{
		try(CandidateDao candidateDao=new CandidateDaoImpl())
		{
			candList=candidateDao.findAll();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
