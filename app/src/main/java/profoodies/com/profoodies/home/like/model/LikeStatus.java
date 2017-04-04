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
 * To check the like status
 * Like - To like the instagram posts
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class LikeStatus extends BaseObservable {

    private boolean isLike = false;

    @Bindable
    public boolean isLike() {
        return isLike;
    }

    /**
     * Sets {@link #isLike}
     */
    public void setLike(boolean toEditOrSave) {
        this.isLike = toEditOrSave;
        notifyPropertyChanged(BR.like);
    }
}
