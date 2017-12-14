package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.entity.GamePlayerResult;

import java.util.List;

@Dao
public interface GamePlayerResultDao {

	@Query( "select game_id, f.firstName, f.lastName, f.nick, sum( score ) as score, count( r.id ) as roundCount\n" +
			"from rounds r\n" +
			"join roundScores rs on rs.round_id = r.id\n" +
			"join friends f on f.id = rs.friend_id\n" +
			"group by r.game_id, rs.friend_id" )
	List<GamePlayerResult> getAll();

	@Query( "select game_id, f.firstName, f.lastName, f.nick, sum( score ) as score, count( r.id ) as roundCount\n" +
			"from rounds r\n" +
			"join roundScores rs on rs.round_id = r.id\n" +
			"join friends f on f.id = rs.friend_id\n" +
			"where game_id = ( :game_id )\n" +
			"group by r.game_id, rs.friend_id" )
	List<GamePlayerResult> loadByGameId( int game_id );
}
