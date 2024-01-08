package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	private int candId;
	private String message;
	
	public DeleteCandidateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void deleteCandidate()
	{
		try(CandidateDao candidateDao=new CandidateDaoImpl())
		{
			int count=candidateDao.deleteById(candId);
			if(count!=0)
			{
				this.message="Candidate Deleted Successfully";
			}
			else {
				this.message="Some error Occured, Candidate ot deleted";
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
