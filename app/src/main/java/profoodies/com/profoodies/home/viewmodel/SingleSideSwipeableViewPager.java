/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.viewmodel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Single side Swipeable Viewpager to remove both side swipe
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class SingleSideSwipeableViewPager extends ViewPager {

    /**
     * Gets the value of motion event
     */
    private float initialXValue;

    /**
     * Gets the value from enum
     */
    private SwipeDirection direction;

    /**
     * public Constructor to pass context and attribute
     *
     * @param context
     * @param attrs
     */
    public SingleSideSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.direction = SwipeDirection.ALL;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isSwipeAllowed(event) && super.onTouchEvent(event);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isSwipeAllowed(event) && super.onInterceptTouchEvent(event);

    }

    /**
     * Method used to allow swipe in single direction
     *
     * @param event
     * @return
     */
    private boolean isSwipeAllowed(MotionEvent event) {
        if (this.direction == SwipeDirection.ALL)
            return true;

        if (direction == SwipeDirection.NONE)//disable any swipe
            return false;

        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            initialXValue = event.getX();
            return true;
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            try {
                float diffX = event.getX() - initialXValue;
                if ((diffX > 0 && direction == SwipeDirection.RIGHT)||(diffX < 0 && direction == SwipeDirection.LEFT)) {
                    // swipe from left to right detected
                    return false;
                }
            } catch (Exception exception) {
                Log.e("TAG", "isSwipeAllowed: " + exception);
            }
        }

        return true;
    }

    public void setAllowedSwipeDirection(SwipeDirection direction) {
        this.direction = direction;
    }

    /**
     * Declared enumeration for viewpager directions
     */
    public enum SwipeDirection {

        ALL, LEFT, RIGHT, NONE;
    }
}

