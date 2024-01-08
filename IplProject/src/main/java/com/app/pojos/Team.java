package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//id , name, abbreviation,owner,max_age,batting_avg,wickets_taken
//one , parent, inverse
@Entity
@Table(name = "teams")
public class Team {
	@Column(length = 100)
	private String name;
	@Column(length = 10)
	private String abbreviation;
	@Column(name = "max_age")
	private int maxAge;// max age of the player allowed in this team
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	// Team 1---->* Player
	// Team : one , parent , inverse
	@OneToMany(mappedBy = "myTeam", 
			cascade = CascadeType.ALL, 
			orphanRemoval = true)
	private List<Player> players = new ArrayList<>();

	@OneToOne
	@MapsId
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	
	




	public Team(String name, String abbreviation, int maxAge, double battingAvg, int wicketsTaken, List<Player> players,
			Owner owner) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
		this.players = players;
		this.owner = owner;
	}



	public Owner getOwner() {
		return owner;
	}



	public void setOwner(Owner owner) {
		this.owner = owner;
	}



	public Team() {
		// TODO Auto-generated constructor stub
	}

	


	public Team(Integer id,String abbreviation) {
		//setId(id);
		this.abbreviation = abbreviation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	//add helper methods to set up bi dir asso
	public void addPlayer(Player p)
	{
		players.add(p);
		p.setMyTeam(this);
	}
	//add helper methods to remove up bi dir asso
		public void removePlayer(Player p)
		{
			players.remove(p);
			p.setMyTeam(null);
		}




		@Override
		public String toString() {
			return "Team [name=" + name + ", abbreviation=" + abbreviation + ", maxAge=" + maxAge + ", battingAvg="
					+ battingAvg + ", wicketsTaken=" + wicketsTaken + ", players=" + players + ", owner=" + owner + "]";
		}

		
}
