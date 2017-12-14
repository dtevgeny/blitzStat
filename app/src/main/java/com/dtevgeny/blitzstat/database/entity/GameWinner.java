package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "gameWinners")
public class GameWinner {

	@PrimaryKey(autoGenerate = true)
	private int id;
	private int game_id;
	private int friend_id;

	public GameWinner() {
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

	public int getFriend_id() {
		return friend_id;
	}

	public void setFriend_id( int friend_id ) {
		this.friend_id = friend_id;
	}
}
