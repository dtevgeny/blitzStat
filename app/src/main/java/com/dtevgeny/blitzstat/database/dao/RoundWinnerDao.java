package com.dtevgeny.blitzstat.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.dtevgeny.blitzstat.database.entity.RoundWinner;

import java.util.List;

@Dao
public interface RoundWinnerDao {

	@Query( "SELECT * FROM roundWinners WHERE round_id = ( :round_id )" )
	List<RoundWinner> loadByRoundId( int round_id );
}
