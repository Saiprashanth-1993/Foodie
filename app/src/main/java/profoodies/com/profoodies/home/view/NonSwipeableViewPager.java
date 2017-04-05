/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * Non Swipeable Fragment to remove default swipe in the tabbed activity
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class NonSwipeableViewPager extends ViewPager {

    /**
     * Constructor of Non Swipeable Viewpager which can invoke the method directly to activity
     *
     * @param context Context of a Fragment
     */
    public NonSwipeableViewPager(Context context) {
        super(context);
        setMyScroller();
    }

    /**
     * Constructor of Non Swipeable Viewpager which can invoke the method directly to activity
     *
     * @param context Context of a Fragment
     * @param attrs   Attributes of the NonSwipeable View pager
     */
    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setMyScroller();
    }

    /**
     * Never allow swiping to switch between pages
     *
     * @param event To Captures the Motion Event
     * @return boolean
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    /**
     * Never allow swiping to switch between pages
     *
     * @param event TO Captures the MotionEvent
     * @return Boolean
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    /**
     * To Set up the View Pager with scroll bar
     */
    private void setMyScroller() {
        try {
            Class<?> viewpager = ViewPager.class;
            Field scroller = viewpager.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            scroller.set(this, new MyScroller(getContext()));
        } catch (Exception e) {
            Log.e("TAG", "setMyScroller: " + e);
        }
    }

    /**
     * Down one is added for smooth scrolling
     */
    public class MyScroller extends Scroller {

        /**
         * Constructor of Scroller which can invoke the Pager scroller with smooth swipe
         *
         * @param context
         */
        public MyScroller(Context context) {
            super(context, new DecelerateInterpolator());
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, 250 /*1 secs*/);
        }
    }
}
