package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.GamePlayer;

import java.util.List;

@Dao
public interface GamePlayerDao {

	@Query( "SELECT * FROM gamePlayers WHERE game_id = ( :game_id )" )
	List<GamePlayer> loadByGameId( int game_id );
}
