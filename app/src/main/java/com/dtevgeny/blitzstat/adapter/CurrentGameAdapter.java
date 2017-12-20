package com.dtevgeny.blitzstat.adapter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dtevgeny.blitzstat.R;
import com.dtevgeny.blitzstat.database.entity.Game;
import com.dtevgeny.blitzstat.database.entity.RoundWinner;
import com.dtevgeny.blitzstat.databinding.ItemBinding;

/**
 * Created by EDOLGY on 18.12.2017.
 * Awesome, isn't it?
 */

public class CurrentGameAdapter extends BaseAdapter {

	private Game game;

	public CurrentGameAdapter( Game game ) {
		this.game = game;
	}

	@Override
	public int getCount() {
		return game.getRounds().size() * game.getGamePlayers().size();
	}

	@Override
	public Object getItem( int i ) {
		return null;
	}

	@Override
	public long getItemId( int i ) {
		return 0;
	}

	@Override
	public View getView( int i, View view, ViewGroup viewGroup ) {
		ItemBinding itemBinding = ItemBinding.inflate( LayoutInflater.from( viewGroup.getContext() ), viewGroup, false );

		TextView textView = itemBinding.getRoot().findViewById( R.id.tvText );
		int playersCount = game.getGamePlayers().size();
		textView.setText( String.valueOf( game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getRoundScores().get( i % playersCount ).getCurrentScore() ) );

		int round_id = game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getId();
		int player_id = game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getRoundScores().get( i % playersCount ).getFriend_id();
		int score = game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getRoundScores().get( i % playersCount ).getScore();

		for ( RoundWinner roundWinner : game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getRoundWinners() ) {
			if ( roundWinner.getFriend_id() == player_id ) {
				textView.setTypeface( null, Typeface.BOLD );
			}
		}

//		textView.setText( textView.getText() + "|" + round_id + "|" + player_id + "|" + score );
		textView.setText( textView.getText() + " | " + score );
//		if ( game.getRounds().get( game.getRounds().size() - i / playersCount - 1 ).getRoundWinners() ) {
//			textView.setTypeface( null, Typeface.BOLD );
//		}

		return itemBinding.getRoot();
	}

	public void setGame( Game game ) {
		this.game = game;
		notifyDataSetChanged();
	}
}
