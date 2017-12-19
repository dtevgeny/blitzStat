package com.dtevgeny.blitzstat.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.dtevgeny.blitzstat.database.entity.Game;
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
//		if ( null == convertView ) {
//			convertView = inflater.inflate(R.layout.photo_item, parent, false);
//		}
//
//		RecyclerItemBinding itemBinding = RecyclerItemBinding.inflate( LayoutInflater.from( parent.getContext() ), parent, false );
//		return new GamesViewHolder( itemBinding );
		ItemBinding itemBinding = ItemBinding.inflate( LayoutInflater.from( viewGroup.getContext() ), viewGroup, false );
		return itemBinding.getRoot();
	}

	public void setGame( Game game ) {
		this.game = game;
		notifyDataSetChanged();
	}
}
