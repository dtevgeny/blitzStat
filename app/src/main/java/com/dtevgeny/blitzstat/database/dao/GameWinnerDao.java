package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.GameWinner;

import java.util.List;

@Dao
public interface GameWinnerDao {

	@Query( "SELECT * FROM gameWinners WHERE game_id = ( :game_id )" )
	List<GameWinner> loadByGameId( int game_id );
}
