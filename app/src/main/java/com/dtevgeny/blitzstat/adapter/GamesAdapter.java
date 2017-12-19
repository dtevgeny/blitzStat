package com.dtevgeny.blitzstat.adapter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dtevgeny.blitzstat.activity.CurrentGameActivity;
import com.dtevgeny.blitzstat.database.entity.Game;
import com.dtevgeny.blitzstat.database.entity.GamePlayer;
import com.dtevgeny.blitzstat.databinding.RecyclerItemBinding;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

	private List<Game> games;

	public GamesAdapter( List<Game> games ) {
		this.games = games;
	}

	@Override
	public GamesViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
		RecyclerItemBinding itemBinding = RecyclerItemBinding.inflate( LayoutInflater.from( parent.getContext() ), parent, false );
		return new GamesViewHolder( itemBinding );
	}

	@Override
	public void onBindViewHolder( GamesViewHolder holder, int position ) {
		holder.bind( games.get( position ) );

		holder.itemView.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick( View view ) {
//				Toast.makeText( view.getContext(), "Clicked on Game with ID = " + String.valueOf( games.get( position ).getId() ), Toast.LENGTH_SHORT ).show();
				Toast.makeText( view.getContext(), "Clicked on Game with ID = " + String.valueOf( games.get( holder.getAdapterPosition() ).getId() ), Toast.LENGTH_SHORT ).show();

				Intent intent = new Intent( view.getContext(), CurrentGameActivity.class );
				intent.putExtra( "game_id", games.get( holder.getAdapterPosition() ).getId() );
				view.getContext().startActivity( intent );
			}
		} );
	}

	@Override
	public int getItemCount() {
		return games.size();
	}

	public void setGames( List<Game> games ) {
		this.games = games;
		notifyDataSetChanged();
	}

	static class GamesViewHolder
			extends RecyclerView.ViewHolder {

		RecyclerItemBinding binding;

		GamesViewHolder( RecyclerItemBinding binding ) {
			super( binding.getRoot() );
			this.binding = binding;
		}

		void bind( Game game ) {

			binding.blogPostTextView.setText( game.getDtStart() );
			if ( game.getGamePlayers() != null ) {
				// TODO uncomment on PROD
				binding.gridLayout.removeAllViews();
				for ( GamePlayer gamePlayer : game.getGamePlayers() ) {

					GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//					layoutParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
//					layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT;

					TextView tv = new TextView( binding.gridLayout.getContext() );
					tv.setLayoutParams( layoutParams );
					tv.setText( "Player #" + gamePlayer.getFriend_id() );
					tv.setBackgroundColor( Color.LTGRAY );

					binding.gridLayout.addView( tv );

					layoutParams = new GridLayout.LayoutParams();
					layoutParams.setGravity( Gravity.END );
//					TODO : add scaling to width [ dps ]
//					WIDTH_50 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
					final float scale = binding.gridLayout.getContext().getResources().getDisplayMetrics().density;
					int pixels = ( int ) ( 50 * scale + 0.5f );
//					layoutParams.width = pixels;
					layoutParams.height = GridLayout.LayoutParams.WRAP_CONTENT;

					tv = new TextView( binding.gridLayout.getContext() );
					tv.setLayoutParams( layoutParams );
					tv.setText( String.valueOf( gamePlayer.getTotalScore() ) );
					tv.setBackgroundColor( Color.MAGENTA );

					tv.setGravity( Gravity.CENTER );

					binding.gridLayout.addView( tv );

				}

			}
			binding.executePendingBindings();
		}
	}
}
