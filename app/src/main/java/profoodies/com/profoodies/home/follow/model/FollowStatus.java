/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.follow.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import profoodies.com.profoodies.BR;

/**
 * To check the Follow status
 * Status - To Follow the instagram users
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class FollowStatus extends BaseObservable {

    /**
     * Boolean Variable is initialized
     */
    private boolean isFollowed = false;

    @Bindable
    public boolean isFollowed() {
        return isFollowed;
    }

    /**
     * Sets {@link #isFollowed}
     */
    public void setFollowed(boolean followed) {
        this.isFollowed = followed;
        notifyPropertyChanged(BR.followed);
    }
}
