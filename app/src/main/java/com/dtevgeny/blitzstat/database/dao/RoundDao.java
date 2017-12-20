package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.Round;

import java.util.List;

@Dao
public interface RoundDao {

	@Query( "SELECT * FROM rounds" )
	List<Round> getAll();

	@Query( "SELECT * FROM rounds WHERE game_id = (:game_id)" )
//	LiveData<List<Round>> loadByGameId( int game_id );
	List<Round> loadByGameId( int game_id );
}
