package com.dtevgeny.blitzstat.entity;

public class GamePlayerResult {

	private int game_id;
	private String firstName;
	private String lastName;
	private String nick;
	private int score;
	private int roundCount;

	public GamePlayerResult() {
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id( int game_id ) {
		this.game_id = game_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick( String nick ) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore( int score ) {
		this.score = score;
	}

	public int getRoundCount() {
		return roundCount;
	}

	public void setRoundCount( int roundCount ) {
		this.roundCount = roundCount;
	}
}
