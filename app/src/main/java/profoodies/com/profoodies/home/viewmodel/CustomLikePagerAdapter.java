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
 * Created by Contus team on 31/3/17.
 */

public class CustomLikePagerAdapter extends PagerAdapter {
    Context context;

    LayoutInflater inflater;

    /**
     * Constructor of Custom Adapter which can invoke the method directly to activity
     *
     * @param context
     */
    public CustomLikePagerAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.fragment_like_pager, container, false);
        container.addView(layout);
        return layout;
    }

    /**
     * to return number of pages in the pager
     * @return
     */
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }

}
