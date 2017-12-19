package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.Intent;

import java.util.Comparator;

@Entity(tableName = "roundScores",
		foreignKeys = @ForeignKey(
				entity = Round.class,
				parentColumns = "id",
				childColumns = "round_id" ) )
public class RoundScore implements Comparable<RoundScore> {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int round_id;
	private int friend_id;
	private int score;

	@Ignore
	private int currentScore;

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

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore( int currentScore ) {
		this.currentScore = currentScore;
	}

	public int compareTo( RoundScore compareRoundScore ) {
		int compareFriend_id = ((RoundScore) compareRoundScore).getFriend_id();

		//ascending order
		return this.friend_id - compareFriend_id;
		//descending order
//		return compareFriend_id - this.friend_id;
	}
}
