/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.customviews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Custom Edit Text class to display the custom error icon
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CustomEditText extends AppCompatEditText {

    /**
     *
     * @param context reference to view
     * @param attrs attrs of the edit text
     */
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * method used to show the error message
     *
     * @param error error message
     * @param icon custom icon
     */
    @Override
    public void setError(CharSequence error, Drawable icon) {
        setCompoundDrawables(null, null, icon, null);
        super.setError(error,icon);
    }
}