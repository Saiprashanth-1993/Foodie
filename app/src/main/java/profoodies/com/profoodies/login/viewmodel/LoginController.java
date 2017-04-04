/*
 * @category FoodLover
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.login.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.ActivityLoginBinding;
import profoodies.com.profoodies.home.view.HomeActivity;
import profoodies.com.profoodies.login.model.UserLogin;
import profoodies.com.profoodies.utils.CustomUtils;

/**
 * Controller for LoginActivity Class
 * XML View Controller
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class LoginController {

    /**
     * Reference for the LoginActivity Databinding
     */
    ActivityLoginBinding activityLoginBinding;

    private Context context;

    /**
     * parametrized constructor
     *
     * @param activityLoginBinding reference for activity login binding
     */
    public LoginController(ActivityLoginBinding activityLoginBinding) {
        this.activityLoginBinding = activityLoginBinding;
    }

    /**
     * OnClick listener of login button.
     *
     * @param userLogin Used to get the login details.
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener btnLoginClick(final UserLogin userLogin) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(view, userLogin.getUsername(), userLogin.getPassword())) {
                    CustomUtils.showSnack(view, "Form Validated");
                    Intent myIntent = new Intent(context, HomeActivity.class);
                    context.startActivity(myIntent);
                }
            }
        };
    }

    /**
     * OnClick listener of login layout to hide soft keyboard.
     *
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener loginLayoutClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                AppCompatActivity loginActivity = (AppCompatActivity) context;
                CustomUtils.hideSoftKeyboard(loginActivity);
            }
        };
    }

    /**
     * OnClick listener of login layout to hide soft keyboard.
     *
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener warningImageClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(view.getContext());

                // Setting Dialog Title
                alertDialog.setTitle("Info");

                // Setting Dialog Message
                alertDialog.setMessage("Only Instagram Users are allowed");

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.ic_warning);

                // Setting Positive  Button
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        };
    }

    /**
     * Method used to validate the username and password.
     *
     * @param view      Used to show the Snack Bar
     * @param userEmail Validate the userEmail.
     * @param password  Validate the password.
     * @return true when the given field is not empty.
     */
    public boolean isValid(View view, String userEmail, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userEmail)) {
            validationStatus = false;
            CustomUtils.showSnack(view, "username field should not be empty");
            activityLoginBinding.etUsername.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            validationStatus = false;
            CustomUtils.showSnack(view, "password field should not be empty");
            activityLoginBinding.etPassword.requestFocus();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            validationStatus = false;
            CustomUtils.showSnack(view, "Please make sure email id is valid");
            activityLoginBinding.etUsername.requestFocus();
        } else if (password.length() < 6) {
            validationStatus = false;
            CustomUtils.showSnack(view, "Please make sure password should have max of 6 character");
            activityLoginBinding.etPassword.requestFocus();
        }
        return validationStatus;
    }
}
