/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.login.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.ActivityLoginBinding;
import profoodies.com.profoodies.login.model.UserLogin;
import profoodies.com.profoodies.login.viewmodel.LoginController;


/**
 * Activity for login, to login the user with Instagram Username and password Authentication
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class ActivityLogin extends AppCompatActivity {

    /**
     * MVVM for the LoginActivity Databinding
     */
    ActivityLoginBinding activityLoginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        /**
         *  To initialize the Model and controller in mvvm
         */
        activityLoginBinding.setModel(new UserLogin());
        activityLoginBinding.setController(new LoginController(activityLoginBinding));


        /**
         * To get the view from screen and passing that to animation
         */
        RelativeLayout loginView = activityLoginBinding.rlLoginParent;
        startAnimation(loginView);
    }

    /**
     * The Method is used to enable the Animation
     *
     * @param view To get the view and start animation in that
     */
    public void startAnimation(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom);
        view.startAnimation(animation);
    }

    /**
     * To Close the App when on Back Pressed
     */
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
