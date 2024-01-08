package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

public class EditCandidateBean {
	private int candId;
	private Candidate candidate;
	
	public EditCandidateBean()
	{
		
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	public void EditCandidate()
	{
		try(CandidateDao candidateDao=new CandidateDaoImpl())
		{
			candidate=candidateDao.findById(candId);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
