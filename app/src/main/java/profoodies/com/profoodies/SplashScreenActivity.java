/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import profoodies.com.profoodies.home.view.HomeActivity;

/**
 * Show the splash image of the app and  if user not logged then they will be redirected to
 * they will be redirected to home
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class SplashScreenActivity extends AppCompatActivity {
    /**
     * Used to handle the runnable thread.
     */
    private Handler threadHandler;

    /**
     * Runnable thread.
     */
    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        threadHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                    Intent loginActivity = new Intent(SplashScreenActivity.this, HomeActivity.class);
                    startActivity(loginActivity);
                    finish();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         *Splash screen timer.
         */
        int splashTimeOut = 1000;
        /**
         * Resume the handler to run the thread when application reopen.
         */
        threadHandler.postDelayed(mRunnable, splashTimeOut);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * Stopping the handler when application minimized.
         */
        threadHandler.removeCallbacks(mRunnable);
    }
}