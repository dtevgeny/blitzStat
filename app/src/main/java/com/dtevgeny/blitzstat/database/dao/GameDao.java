package com.dtevgeny.blitzstat.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.dtevgeny.blitzstat.database.entity.Game;

import java.util.List;

@Dao
public interface GameDao {

	@Query( "SELECT * FROM games" )
	LiveData<List<Game>> getAll();
//	List<Game> getAll();

	@Query( "SELECT COUNT(*) FROM games" )
	int rowCount();

	@Query( "SELECT * FROM games WHERE id = ( :id )" )
	Game getById( int id );

	@Insert
	void insertGames(Game... games);

	@Update
	void updateGames(Game... games);

	@Delete
	void deleteGames(Game... games);
}
