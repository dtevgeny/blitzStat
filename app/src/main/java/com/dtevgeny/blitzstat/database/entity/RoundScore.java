package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "roundScores",
		foreignKeys = @ForeignKey(
				entity = Round.class,
				parentColumns = "id",
				childColumns = "round_id" ) )
public class RoundScore {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int round_id;
	private int friend_id;
	private int score;

	public RoundScore() {
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

	public int getScore() {
		return score;
	}

	public void setScore( int score ) {
		this.score = score;
	}
}
