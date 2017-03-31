/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.home.like.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import profoodies.com.profoodies.BR;

/**
 * To set a boolean value for like button
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class LikeModel extends BaseObservable {

    private boolean isToLikeOrUnlike = false;

    @Bindable
    public boolean isToLikeOrUnlike() {
        return isToLikeOrUnlike;
    }

    /**
     * Sets {@link #isToLikeOrUnlike}
     */
    public void setToLikeOrUnlike(boolean toEditOrSave) {
        this.isToLikeOrUnlike = toEditOrSave;
        notifyPropertyChanged(BR.toLikeOrUnlike);
    }
}
