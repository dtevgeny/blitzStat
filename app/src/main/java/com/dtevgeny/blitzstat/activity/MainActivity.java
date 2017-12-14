package com.dtevgeny.blitzstat.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.dtevgeny.blitzstat.R;
import com.dtevgeny.blitzstat.adapter.GamesAdapter;
import com.dtevgeny.blitzstat.databinding.ActivityMainBinding;
import com.dtevgeny.blitzstat.viewModel.GamesViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		ActivityMainBinding binding = DataBindingUtil.setContentView( this, R.layout.activity_main );

		GamesAdapter gamesAdapter = new GamesAdapter( new ArrayList<>() );
		binding.recyclerView.setLayoutManager( new LinearLayoutManager( this ) );
		binding.recyclerView.setAdapter( gamesAdapter );

		binding.fab.setOnClickListener( view ->
				Toast.makeText( view.getContext(), "FAB Click", Toast.LENGTH_SHORT ).show()
		);

		GamesViewModel viewModel = ViewModelProviders.of( this ).get( GamesViewModel.class );

		viewModel.getGames().observe( this, gamesAdapter::setGames );

	}
}

//-- all game results
//		select game_id, rs.friend_id, sum( score ), count( r.id )
//		from rounds r
//		join roundScores rs on rs.round_id = r.id
//		group by r.game_id, rs.friend_id;
