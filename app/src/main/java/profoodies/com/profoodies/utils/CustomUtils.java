/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.utils;
import android.support.design.widget.Snackbar;
import android.view.View;

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
     * @param view View of the activity or fragment
     * @param message Message to show in Snack bar
     */
    public static void showSnack(View view, String message){
        Snackbar snackbar = Snackbar
                .make(view,message,Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}