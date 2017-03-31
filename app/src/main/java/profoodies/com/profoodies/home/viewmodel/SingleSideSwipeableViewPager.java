/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.home.viewmodel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Single side Swipeable Viewpager to remove both side swipe
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class SingleSideSwipeableViewPager extends ViewPager {

    float lastX = 0;

    boolean lockScroll = false;

    /**
     * public Constructor to pass context and attribute
     *
     * @param context
     * @param attrs
     */
    public SingleSideSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * public Constructor to pass context
     *
     * @param context
     */
    public SingleSideSwipeableViewPager(Context context) {
        super(context);
    }

}
