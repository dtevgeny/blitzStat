package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "roundWinners")
public class RoundWinner {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int round_id;
	private int friend_id;

	public RoundWinner() {
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getRound_id() {
		return round_id;
	}

	public void setRound_id( int round_id ) {
		this.round_id = round_id;
	}

	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id( int friend_id ) {
		this.friend_id = friend_id;
	}
}
