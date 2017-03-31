/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.walkthrough.viewmodel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import profoodies.com.profoodies.R;


/**
 * This is the adapter class used to load the images about the ProFoodies app. This is the
 * GetStarted slides used to give a short description about the app and its usage to the users as
 * the initial screen after installing the application
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class GetStartedAdapter extends PagerAdapter {

    /**
     * Added static images
     */
    private int[] mResources = {
            R.drawable.temp_logo,
            R.drawable.temp_logo,
            R.drawable.temp_logo,
    };

    /**
     * Added static title
     */
    private int[] strTitle = {
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
    };

    /**
     * Added static contents
     */
    private int[] strContents = {
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
    };

    /**
     * Inflate the layout for showing the views
     */
    private LayoutInflater mLayoutInflater;

    /**
     * Constructor used to instantiate the adapter class
     *
     * @param context Activity context
     */
    public GetStartedAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.item_aboutimage, container, false);
        if (itemView != null) {

            ImageView ivAbout = (ImageView) itemView.findViewById(R.id.img_about);
            TextView txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            TextView txtContent = (TextView) itemView.findViewById(R.id.txt_content);
            ivAbout.setImageResource(mResources[position]);
            txtTitle.setText(strTitle[position]);

            /**
             * Setting the text of content based on the position of the item and the strContents
             */
            txtContent.setText(strContents[position]);

            container.addView(itemView);
        }
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
