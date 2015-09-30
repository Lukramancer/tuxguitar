package org.herac.tuxguitar.android.fragment;

import org.herac.tuxguitar.android.activity.R;
import org.herac.tuxguitar.android.activity.TGActivity;
import org.herac.tuxguitar.android.menu.options.TGChannelListMenu;
import org.herac.tuxguitar.util.TGContext;
import org.herac.tuxguitar.util.singleton.TGSingletonFactory;
import org.herac.tuxguitar.util.singleton.TGSingletonUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class TGChannelListFragment extends TGCachedFragment {
	
	public TGChannelListFragment(TGContext context) {
		super(context, R.layout.view_channel_list);
	}
	
	@Override
	public void onPostCreate(Bundle savedInstanceState) {
		this.setHasOptionsMenu(true);
	}
	
	@Override
	public void onPostCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
		menuInflater.inflate(R.menu.menu_channel_list, menu);
		
		TGActivity activity = (TGActivity) getActivity();
		TGChannelListMenu.getInstance(this.findContext()).initialize(activity, menu);
	}
	
	public static TGChannelListFragment getInstance(TGContext context) {
		return TGSingletonUtil.getInstance(context, TGChannelListFragment.class.getName(), new TGSingletonFactory<TGChannelListFragment>() {
			public TGChannelListFragment createInstance(TGContext context) {
				return new TGChannelListFragment(context);
			}
		});
	}
}
