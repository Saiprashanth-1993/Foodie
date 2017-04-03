/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Adapter class for Binding Like, Follow Fragments inside Home
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class HomepageAdapter extends FragmentStatePagerAdapter {

    /**
     * Title of the fragment list.
     */
    private String[] mTitle;
    /**
     * Fragment list Which contains the fragments on the adapter.
     */

    private List<Fragment> fragmentList;

    /**
     * Instantiates a new adapter dashboard view.
     *
     * @param fm the Instance of the FragmentManager.
     */

    public HomepageAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Set the list of title from the activity.
     *
     * @param titles Title list.
     */

    public void setTitle(String[] titles) {
        this.mTitle = titles;
    }

    /**
     * Set the fragment list for the particular view pager using FragmentStatePagerAdapter.
     *
     * @param fragmentList List of fragment.
     */

    public void setFragmentList(List<Fragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
