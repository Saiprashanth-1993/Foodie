/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Common utils used for the application
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class CustomUtils {

    private CustomUtils() {
        //Default constructor
    }

    /**
     * show the snackbar
     *
     * @param view    View of the activity or fragment
     * @param message Message to show in Snack bar
     */
    public static void showSnack(View view, String message) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    /**
     * Use this method to hide the keyboard if it is showing
     *
     * @param activity current activity
     */
    public static void hideSoftKeyboard(Activity activity) {

        View activeView = activity.getCurrentFocus();
        if (activeView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity
                    .INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activeView.getWindowToken(), 0);
        }
    }
}