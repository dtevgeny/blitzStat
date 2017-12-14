package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.Friend;

import java.util.List;

@Dao
public interface FriendDao {

	@Query( "SELECT * FROM friends" )
	List<Friend> getAll();
}
