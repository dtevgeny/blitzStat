package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.Context;

import com.dtevgeny.blitzstat.database.AppDatabase;

import java.util.List;

@Entity( tableName = "games" )
public class Game {

	@PrimaryKey( autoGenerate = true )
	private int id;

	//	private int global_id;
	private String dtStart;
	private String dtEnd;
	private String dtUpload;
	private String dtApproved;

	@Ignore
	private List<Round> rounds;

	@Ignore
	private List<GamePlayer> gamePlayers;

	@Ignore
	private List<GameWinner> gameWinners;

	public Game() {

	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getDtStart() {
		return dtStart;
	}

	public void setDtStart( String dtStart ) {
		this.dtStart = dtStart;
	}

	public String getDtEnd() {
		return dtEnd;
	}

	public void setDtEnd( String dtEnd ) {
		this.dtEnd = dtEnd;
	}

	public String getDtUpload() {
		return dtUpload;
	}

	public void setDtUpload( String dtUpload ) {
		this.dtUpload = dtUpload;
	}

	public String getDtApproved() {
		return dtApproved;
	}

	public void setDtApproved( String dtApproved ) {
		this.dtApproved = dtApproved;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds( List<Round> rounds ) {
		this.rounds = rounds;
	}

	public List<GamePlayer> getGamePlayers() {
		return gamePlayers;
	}

	public void setGamePlayers( List<GamePlayer> gamePlayers ) {
		this.gamePlayers = gamePlayers;
	}

	public List<GameWinner> getGameWinners() {
		return gameWinners;
	}

	public void setGameWinners( List<GameWinner> gameWinners ) {
		this.gameWinners = gameWinners;
	}

	public void calculateGamePlayersScore() {

		for ( GamePlayer gamePlayer : this.getGamePlayers() ) {
			gamePlayer.totalScore = 0;
		}

		for ( Round round : this.getRounds() ) {
			for ( RoundScore roundScore : round.getRoundScores() ) {
				for ( GamePlayer gamePlayer : this.getGamePlayers() ) {
					if ( gamePlayer.getFriend_id() == roundScore.getFriend_id() ) {
						gamePlayer.totalScore += roundScore.getScore();
					}
				}
			}
		}
	}

	public void populate( Context context, Class... toLoad ) {
		AppDatabase db = AppDatabase.getInstance( context );
		populate( db, toLoad );
	}

	public void populate( AppDatabase db, Class... toLoad ) {

		this.setRounds( db.roundDao().loadByGameId( this.getId() ) );
		this.setGamePlayers( db.gamePlayerDao().loadByGameId( this.getId() ) );
		this.setGameWinners( db.gameWinnerDao().loadByGameId( this.getId() ) );

		for ( Round round : this.getRounds() ) {
			round.setRoundScores( db.roundScoreDao().loadByRoundId( round.getId() ) );
			round.setRoundWinners( db.roundWinnerDao().loadByRoundId( round.getId() ) );
		}

		this.calculateGamePlayersScore();
	}

}
