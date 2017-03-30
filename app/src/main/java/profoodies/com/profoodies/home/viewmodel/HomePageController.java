package profoodies.com.profoodies.home.viewmodel;

import android.view.View;

import profoodies.com.profoodies.home.follow.model.FollowModel;
import profoodies.com.profoodies.home.like.model.LikeModel;
import xyz.hanks.library.SmallBang;

/**
 * Created by Contus team on 29/3/17.
 */

public class HomePageController {
    SmallBang smallBang;

    public HomePageController(SmallBang smallBang) {
        this.smallBang = smallBang;
    }

    public View.OnClickListener FavbtnClick(final LikeModel likeModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                smallBang.bang(view);
                likeModel.setToEditOrSave(true);
            }
        };
    }

    public View.OnClickListener FollowbtnClick(final FollowModel fModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                smallBang.bang(view);
                fModel.setToEditOrSave(true);
            }
        };
    }
}
