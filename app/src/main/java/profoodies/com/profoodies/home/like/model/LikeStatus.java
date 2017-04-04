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

    private boolean isLiked = false;

    @Bindable
    public boolean isLiked() {
        return isLiked;
    }

    /**
     * Sets {@link #isLiked}
     */
    public void setLiked(boolean toEditOrSave) {
        this.isLiked = toEditOrSave;
        notifyPropertyChanged(BR.like);
    }
}
