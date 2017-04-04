/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentHomepageBinding;
import profoodies.com.profoodies.home.follow.view.FollowFragment;
import profoodies.com.profoodies.home.like.view.LikeFragment;
import profoodies.com.profoodies.interfaces.IFavouriteMedia;

/**
 * Fragment to merge like fragment and follow fragment
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class HomepageFragment extends Fragment implements IFavouriteMedia {

    Menu menu;

    private FragmentHomepageBinding homepageBinding;

    public HomepageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homepageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false);
        setTabs();
        setHasOptionsMenu(true);
        return homepageBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        this.menu = menu;
        inflater.inflate(R.menu.coins_counter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    /**
     * Set up the Like fragment and Follow fragment in the tab
     */
    private void setTabs() {
        String[] mTitle = new String[]{"Like", "Follow"};
        FragmentManager fm = getChildFragmentManager();
        HomepageAdapter mAdapter = new HomepageAdapter(fm);
        mAdapter.setTitle(mTitle);
        mAdapter.setFragmentList(getFragmentList());
        homepageBinding.viewpager.setAdapter(mAdapter);
        homepageBinding.tabs.setupWithViewPager(homepageBinding.viewpager);
    }

    private List<Fragment> getFragmentList() {
        /**
         * Add the fragment as a list.
         */
        List<Fragment> fragmentList = new ArrayList<>();
        LikeFragment likeFragment = LikeFragment.newInstance(this);
        FollowFragment followFragment = FollowFragment.newInstance(this);
        fragmentList.add(likeFragment);
        fragmentList.add(followFragment);
        return fragmentList;
    }

    @Override
    public void favouriteOnClick() {
        int coinsValue;
        String coins = menu.getItem(0).getTitle().toString();
        coinsValue = Integer.parseInt(coins);
        coinsValue++;
        menu.getItem(0).setTitle(String.valueOf(coinsValue));
    }
}
