package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class ResultBean {
	private List<Candidate> candList;

	public ResultBean()
	{
		this.candList=new ArrayList<>();
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
			throw new RuntimeException(e);
		}
	}
	
}
