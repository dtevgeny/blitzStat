package com.dtevgeny.blitzstat.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity( tableName = "friends" )
public class Friend {

	@PrimaryKey( autoGenerate = true )
	private int id;
	private int player_id;
	private String firstName;
	private String lastName;
	private String nick;
	private String avatar;

	public Friend() {
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id( int player_id ) {
		this.player_id = player_id;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar( String avatar ) {
		this.avatar = avatar;
	}
}
