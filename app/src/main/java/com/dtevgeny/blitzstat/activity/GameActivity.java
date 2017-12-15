package com.dtevgeny.blitzstat.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.TextView;

import com.dtevgeny.blitzstat.R;
import com.dtevgeny.blitzstat.database.AppDatabase;
import com.dtevgeny.blitzstat.database.entity.Game;
import com.dtevgeny.blitzstat.database.entity.Round;

public class GameActivity extends AppCompatActivity {

	@Override
	protected void onCreate( @Nullable Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_game );

		int game_id = getIntent().getIntExtra( "game_id", 0 );


		Game game = AppDatabase.getInstance( this ).gameDao().getById( game_id );
		game.populate( this );

		GridLayout gridLayout = findViewById( R.id.grid_layout );
		gridLayout.setColumnCount( game.getGamePlayers().size() );


		for ( Round round : game.getRounds() ) {

			GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//			GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED, 1f),      GridLayout.spec(GridLayout.UNDEFINED, 1f));
//			layoutParams.width = GridLayout.LayoutParams.MATCH_PARENT;

			TextView tv = new TextView( gridLayout.getContext() );
			tv.setLayoutParams( layoutParams );
			tv.setText( "TEST" );
			tv.setBackgroundColor( Color.LTGRAY );

			gridLayout.addView( tv );

		}

	}
}
