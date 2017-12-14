package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.RoundScore;

import java.util.List;

@Dao
public interface RoundScoreDao {

	@Query( "SELECT * FROM roundScores WHERE round_id = (:round_id)" )
	List<RoundScore> loadByRoundId( int round_id );
}
