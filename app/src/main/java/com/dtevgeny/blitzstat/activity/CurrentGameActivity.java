package com.dtevgeny.blitzstat.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.dtevgeny.blitzstat.R;
import com.dtevgeny.blitzstat.adapter.CurrentGameAdapter;
import com.dtevgeny.blitzstat.adapter.GamesAdapter;
import com.dtevgeny.blitzstat.database.AppDatabase;
import com.dtevgeny.blitzstat.database.entity.Game;
import com.dtevgeny.blitzstat.databinding.ActivityCurrentGameBinding;
import com.dtevgeny.blitzstat.databinding.ActivityMainBinding;
import com.dtevgeny.blitzstat.viewModel.CurrentGameViewModel;
import com.dtevgeny.blitzstat.viewModel.GamesViewModel;

import java.util.ArrayList;

public class CurrentGameActivity extends AppCompatActivity {

	String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
	GridView gvMain;
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
//		setContentView( R.layout.activity_current_game );

		int game_id = getIntent().getIntExtra( "game_id", 0 );

///////////////////////////////////////////////////////////////////////
		ActivityCurrentGameBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_current_game );

		Game game = new Game();
		game.populate( this );
		CurrentGameAdapter currentGameAdapter = new CurrentGameAdapter( game );
		binding.gvMain.setAdapter( currentGameAdapter );

//		ViewModelProviders.of(this, new SampleViewModelFactory(sampleRepo)).get(SampleViewModel.class)

		CurrentGameViewModel.Factory factory = new CurrentGameViewModel.Factory(
				this.getApplication(), game_id );

		CurrentGameViewModel viewModel = ViewModelProviders.of( this, factory ).get( CurrentGameViewModel.class );
		viewModel.getGame().observe( this, currentGameAdapter::setGame );


///////////////////////////////////////////////////////////////////////
//		Game game = AppDatabase.getInstance( this ).gameDao().getById( game_id );
//		game.populate( this );

//		GridLayout gridLayout = findViewById( R.id.grid_layout );
//		gridLayout.setColumnCount( game.getGamePlayers().size() );
//
//
//		for ( Round round : game.getRounds() ) {
//
//			for ( RoundScore roundScore : round.getRoundScores() ) {
//				GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
////				GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 1f),      GridLayout.spec(GridLayout.UNDEFINED, 1f));
////				layoutParams.width = GridLayout.LayoutParams.MATCH_PARENT;
//
//				TextView tv = new TextView( gridLayout.getContext() );
//				tv.setLayoutParams( layoutParams );
//				tv.setGravity( Gravity.FILL );
//				tv.setText( String.format( "[%s] %s", roundScore.getFriend_id(), roundScore.getScore() ) );
//				tv.setBackgroundColor( Color.LTGRAY );
//
//				gridLayout.addView( tv );
//			}
//		}

//		adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.tvText, data);
//		gvMain = (GridView) findViewById(R.id.gvMain);
//		gvMain.setAdapter(adapter);
//		adjustGridView();



	}

	private void adjustGridView() {
		gvMain.setNumColumns(4);
		gvMain.setVerticalSpacing(5);
		gvMain.setHorizontalSpacing(5);
	}
}
