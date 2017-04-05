/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.walkthrough.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import profoodies.com.profoodies.databinding.ActivityGetstartedBinding;
import profoodies.com.profoodies.home.view.HomeActivity;

/**
 * The Controller Class for the Walk Through Screen, which Handles skip, next , continue Btn Clicks
 * Handles the swipe functionality of the view pager
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class ViewController {

    /**
     * Reference for the context, to access view elements
     */
    Context context;

    /**
     * Reference for the GetStarted Activity Databinding
     */
    ActivityGetstartedBinding activityGetstartedBinding;

    /**
     * Parametrized Constructor to get the Databinding Reference
     *
     * @param activityGetstartedBinding Databinding Reference
     */
    public ViewController(ActivityGetstartedBinding activityGetstartedBinding) {
        this.activityGetstartedBinding = activityGetstartedBinding;
    }

    /**
     * Function for Skip Button Click, that ignores Walk through Screen, goes to Login Screen
     *
     * @return onclick Listener action
     */
    public View.OnClickListener skipBtnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                skip(context);
            }
        };
    }

    /**
     * Skip to the login page
     *
     * @param context reference to Activity
     */
    public void skip(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    /**
     * Function for Continue Button Click, after finishing Walk through Screen, goes to Login Screen
     *
     * @return onclick Listener action
     */
    public View.OnClickListener continueBtnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                skip(context);
            }
        };

    }

    /**
     * Function for Next Button Click, that Used to traverse Walk through Screen
     *
     * @return onclick Listener action
     */
    public View.OnClickListener nextBtnCLick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                activityGetstartedBinding.viewPager.setCurrentItem(getItem(+1), true);
            }
        };

    }

    /**
     * Get position of the page in view pager
     *
     * @param i Position
     * @return Next position
     */
    private int getItem(int i) {
        return activityGetstartedBinding.viewPager.getCurrentItem() + i;
    }
}
