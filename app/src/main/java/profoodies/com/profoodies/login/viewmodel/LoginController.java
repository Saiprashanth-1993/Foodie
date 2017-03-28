/**
 * @category FoodLover
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.login.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

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

    private Context context;

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
                if (isValid(view, userLogin.getUsername(), userLogin.getPassword())){
                    CustomUtils.showSnack(view,"Form Validated");
                    Intent myIntent = new Intent(context, HomeActivity.class);
                    context.startActivity(myIntent);
                }
            }
        };
    }

    /**
     * Method used to validate the username and password.
     *
     * @param view  Used to show the Snack Bar
     * @param userEmail Validate the userEmail.
     * @param password Validate the password.
     * @return true when the given field is not empty.
     */
    public boolean isValid(View view, String userEmail, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userEmail)) {
            validationStatus = false;
            CustomUtils.showSnack(view,"Please make sure usernamefield should not be empty");
        } else if (TextUtils.isEmpty(password)) {
            validationStatus = false;
            CustomUtils.showSnack(view,"Please make sure password field should not be empty");
        }  else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            validationStatus = false;
            CustomUtils.showSnack(view,"Please make sure email id is valid");
        }else if (password.length() < 6) {
            validationStatus = false;
            CustomUtils.showSnack(view,"Please make sure password should have max of 6 character");
        }
        return validationStatus;
    }
}
