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
 * To set a boolean value for follow button
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class FollowModel extends BaseObservable {

    private boolean isToFollowOrUnfollow = false;

    @Bindable
    public boolean isToFollowOrUnfollow() {
        return isToFollowOrUnfollow;
    }

    /**
     * Sets {@link #isToFollowOrUnfollow}
     */
    public void setToFollowOrUnfollow(boolean toFollowOrUnfollow) {
        this.isToFollowOrUnfollow = toFollowOrUnfollow;
        notifyPropertyChanged(BR.toFollowOrUnfollow);
    }
}
