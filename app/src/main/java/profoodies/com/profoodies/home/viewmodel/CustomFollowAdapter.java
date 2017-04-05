/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.viewmodel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import profoodies.com.profoodies.R;

/**
 * An adapter used to inflate a view in a view pager
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class CustomFollowAdapter extends PagerAdapter {

    /**
     * Gets the context of the Activity
     */
    Context context;

    /**
     * To inflate the view inside the viewpager
     */
    LayoutInflater inflater;

    /**
     * Constructor of Custom Adapter which can invoke the method directly to activity
     *
     * @param context
     */
    public CustomFollowAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * To return number of pages in the pager
     *
     * @return 20
     */
    @Override
    public int getCount() {
        return 20;
    }

    /**
     * To instantiate the view item
     *
     * @param container
     * @param position
     * @return item view
     */
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_user_pager, container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
