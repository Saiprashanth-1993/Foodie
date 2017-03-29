package profoodies.com.profoodies.home.follow.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Contus team on 28/3/17.
 */

public class FollowModel extends BaseObservable {

    private boolean isToEditOrSave=false;

    @Bindable
    public boolean isToEditOrSave() {
        return isToEditOrSave;
    }

    /**
     * Sets {@link #isToEditOrSave}
     */
    public void setToEditOrSave(boolean toEditOrSave) {
        this.isToEditOrSave = toEditOrSave;
        notifyPropertyChanged(BR.toEditOrSave);
    }
}
