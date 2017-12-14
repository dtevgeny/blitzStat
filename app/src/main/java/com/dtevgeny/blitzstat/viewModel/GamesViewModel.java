package com.dtevgeny.blitzstat.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;

import com.dtevgeny.blitzstat.database.AppDatabase;
import com.dtevgeny.blitzstat.database.entity.Game;

import java.util.List;

public class GamesViewModel extends AndroidViewModel {

	private final LiveData<List<Game>> games;

	public GamesViewModel( @NonNull Application application ) {
		super( application );

		/*	https://developer.android.com/reference/android/arch/lifecycle/Transformations.html */
		games = Transformations.map( AppDatabase.getInstance( this.getApplication() ).gameDao().getAll(), games -> {
			for ( Game game : games ) {
				game.populate( this.getApplication() );
			}
			return games;
		} );
	}

	public LiveData<List<Game>> getGames() {
		return games;
	}
}
