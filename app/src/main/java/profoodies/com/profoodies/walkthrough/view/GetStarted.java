/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.walkthrough.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.ActivityGetstartedBinding;
import profoodies.com.profoodies.walkthrough.viewmodel.GetStartedAdapter;
import profoodies.com.profoodies.walkthrough.viewmodel.ViewController;

/**
 * Activity for Get started, to display the tutorial to the user
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class GetStarted extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    /**
     * Reference for the LoginActivity Databinding
     */
    ActivityGetstartedBinding activityGetstartedBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityGetstartedBinding = DataBindingUtil.setContentView(this, R.layout.activity_getstarted);
        activityGetstartedBinding.setViewController(new ViewController(activityGetstartedBinding));
        GetStartedAdapter getStartedAdapter = new GetStartedAdapter(this);
        activityGetstartedBinding.viewPager.setAdapter(getStartedAdapter);
        activityGetstartedBinding.indicator.setViewPager(activityGetstartedBinding.viewPager);
        activityGetstartedBinding.viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        /**
         * Unused method of the Listener
         */
    }

    /**
     * Method that handles show/hide of Skip,Continue, next button based on screen select
     *
     * @param position view item position in view pager
     */
    @Override
    public void onPageSelected(int position) {
        if (position == 2) {
            activityGetstartedBinding.indicator.setVisibility(View.INVISIBLE);
            activityGetstartedBinding.skip.setVisibility(View.INVISIBLE);
            activityGetstartedBinding.next.setVisibility(View.INVISIBLE);
            activityGetstartedBinding.continueButton.setVisibility(View.VISIBLE);
        } else {
            activityGetstartedBinding.indicator.setVisibility(View.VISIBLE);
            activityGetstartedBinding.skip.setVisibility(View.VISIBLE);
            activityGetstartedBinding.next.setVisibility(View.VISIBLE);
            activityGetstartedBinding.continueButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        /**
         * Unused method of the Listener
         */
    }
}
