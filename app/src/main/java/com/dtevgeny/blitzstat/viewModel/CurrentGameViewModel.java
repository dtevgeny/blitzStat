package com.dtevgeny.blitzstat.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.dtevgeny.blitzstat.database.AppDatabase;
import com.dtevgeny.blitzstat.database.entity.Game;

import java.util.List;

public class CurrentGameViewModel extends AndroidViewModel {

	private final LiveData<Game> game;

	public CurrentGameViewModel( @NonNull Application application, final int id ) {
		super( application );

		/*	https://developer.android.com/reference/android/arch/lifecycle/Transformations.html */
		game = Transformations.map( AppDatabase.getInstance( this.getApplication() ).gameDao().getById( id ), game -> {
					game.populate( this.getApplication() );
					return game;
				}
		);
	}

	public LiveData<Game> getGame() {
		return game;
	}

	/**
	 * A creator is used to inject the product ID into the ViewModel
	 * <p>
	 * This creator is to showcase how to inject dependencies into ViewModels. It's not
	 * actually necessary in this case, as the product ID can be passed in a public method.
	 */
	public static class Factory extends ViewModelProvider.NewInstanceFactory {

		@NonNull
		private final Application mApplication;

		private final int mGameId;

		public Factory(@NonNull Application application, int productId) {
			mApplication = application;
			mGameId = productId;
		}

		@Override
		public <T extends ViewModel> T create(Class<T> modelClass) {
			//noinspection unchecked
			return (T) new CurrentGameViewModel(mApplication, mGameId);
		}
	}

}
