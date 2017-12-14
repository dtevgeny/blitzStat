package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "rounds",
		foreignKeys = @ForeignKey(
				entity = Game.class,
				parentColumns = "id",
				childColumns = "game_id" ) )
public class Round {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int game_id;
	private String dtEnd;

	@Ignore
	private List<RoundScore> roundScores;

	@Ignore
	private List<RoundWinner> roundWinners;

	public Round() {
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getGame_id() {
		return game_id;
	}

	public void setGame_id( int game_id ) {
		this.game_id = game_id;
	}

	public String getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd( String dtEnd ) {
		this.dtEnd = dtEnd;
	}

	public List<RoundScore> getRoundScores() {
		return roundScores;
	}

	public void setRoundScores( List<RoundScore> roundScores ) {
		this.roundScores = roundScores;
	}

	public List<RoundWinner> getRoundWinners() {
		return roundWinners;
	}

	public void setRoundWinners( List<RoundWinner> roundWinners ) {
		this.roundWinners = roundWinners;
	}
}
