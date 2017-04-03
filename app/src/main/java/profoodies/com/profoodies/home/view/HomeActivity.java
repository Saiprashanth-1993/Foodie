/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.view;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import profoodies.com.profoodies.GetCoins;
import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.ActivityHomeBinding;
import profoodies.com.profoodies.utils.Constants;

/**
 * Activity to display the Home, Likes & follow tabs and navigation controller which is used to display the details
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * Activity Home Binding for initializing the layout as data binding.
     */
    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        setSupportActionBar(activityHomeBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        /**
         * for customizing the action bar drawer toggle to overriding default behaviour
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, activityHomeBinding.drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            /**
             * Initialize the linear layout to move the layout
             */
            CoordinatorLayout coordinatorLayout = activityHomeBinding.parent;

            /**
             * overriding onDrawer Slide, to move the layout when navigation drawer clicked
             *
             * @param drawerView Navigation drawer view
             * @param slideOffset moving offset position
             */
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = drawerView.getWidth() * slideOffset;
                coordinatorLayout.setTranslationX(moveFactor);
            }
        };

        activityHomeBinding.drawerLayout.addDrawerListener(toggle);
        activityHomeBinding.navigationView.setNavigationItemSelectedListener(this);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_harmburger);

        /**
         * To set the title color in white
         */
        activityHomeBinding.toolbar.setTitleTextColor(Color.WHITE);

        /**
         * To set the drawer scrim color to transparent, to avoid the shade
         */
        activityHomeBinding.drawerLayout.setScrimColor(Color.TRANSPARENT);
        /**
         *  Trigger the listener for navigation drawer
         */
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activityHomeBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    activityHomeBinding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    activityHomeBinding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        /**
         * Select the first menu from navigation view by default
         */
        onNavigationItemSelected(activityHomeBinding.navigationView.getMenu().getItem(0));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        /**
         *Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
         */
        int i = item.getItemId();
        if (i == android.R.id.home) {
            activityHomeBinding.drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        /**
         *Handle navigation view item clicks here
         */
        item.setChecked(true);
        displaySelectedScreen(item.getItemId());
        return true;
    }

    /**
     * Method used as navigation selection option.
     *
     * @param itemId Get the item of menus
     */
    public void displaySelectedScreen(int itemId) {

        /**
         * Local Variables for Fragment and fragment name
         */
        Fragment fragment = null;
        String fragmentName = null;

        /**
         *  Condition checks for Fragment to be replaced
         */
        if (itemId == R.id.nav_getcoins) {
            fragment = new HomepageFragment();
            fragmentName = Constants.NAME_NAVIGATION_GET_COINS;
        } else if (itemId == R.id.nav_promotions) {
            fragment = new GetCoins();
            fragmentName = Constants.NAME_NAVIGATION_PROMOTIONS;
        } else if (itemId == R.id.nav_store) {
            fragment = new GetCoins();
            fragmentName = Constants.NAME_NAVIGATION_STORE;
        } else if (itemId == R.id.nav_settings) {
            fragment = new GetCoins();
            fragmentName = Constants.NAME_NAVIGATION_SETTINGS;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fl_container, fragment).commit();
            setTitle(fragmentName);
        }

        /**
         * close the navigation view after loaded the fragment
         */
        activityHomeBinding.drawerLayout.closeDrawer(GravityCompat.START);
    }

    /**
     * Method used for handle onBackPressed.
     */
    @Override
    public void onBackPressed() {
        if (activityHomeBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            activityHomeBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            /**
             * Close the App when Back button pressed in Home
             */
            finishAffinity();
        }
    }
}
