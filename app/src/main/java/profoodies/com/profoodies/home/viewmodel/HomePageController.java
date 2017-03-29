package profoodies.com.profoodies.home.viewmodel;

import android.view.View;

import profoodies.com.profoodies.home.follow.model.FollowModel;
import profoodies.com.profoodies.home.like.model.LikeModel;

/**
 * Created by Contus team on 29/3/17.
 */

public class HomePageController {

    public View.OnClickListener FavbtnClick(final LikeModel likeModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                likeModel.setToEditOrSave(true);
            }
        };
    }

    public View.OnClickListener FollowbtnClick(final FollowModel fModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fModel.setToEditOrSave(true);
            }
        };
    }
}
