/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.home.viewmodel;

import android.view.View;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentFollowBinding;
import profoodies.com.profoodies.databinding.FragmentLikeBinding;
import profoodies.com.profoodies.home.follow.model.FollowModel;
import profoodies.com.profoodies.home.like.model.LikeModel;
import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;

/**
 * Controller of the HomePageFragment class
 * XML view controller trigger all the even listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class HomePageController {
    SmallBang smallBang;
    FragmentLikeBinding fragmentLikeBinding;
    FragmentFollowBinding fragmentFollowBinding;

    /**
     *Constructor of Home Page Controller which can invoke the method directly to activity
     * Smallbang is used for button animation
     *
     * @param smallBang
     */
    public HomePageController(SmallBang smallBang, FragmentLikeBinding fragmentLikeBinding) {
        this.smallBang = smallBang;
        this.fragmentLikeBinding = fragmentLikeBinding;
    }

    public HomePageController(SmallBang smallBang, FragmentFollowBinding fragmentFollowBinding) {
        this.smallBang = smallBang;
        this.fragmentFollowBinding = fragmentFollowBinding;
    }

    /**
     * Trigger the event listener action for  profile edit button.
     *
     * @param likeModel Get the model of LikeFragment
     * @return View.OnClickListener OnClickListener of the profile edit click button
     */

    public View.OnClickListener favBtnClick(final LikeModel likeModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                likeModel.setToLikeOrUnlike(true);
                likeBtn(view);

            }
        };
    }

    public void likeBtn(View view){
        smallBang.bang(view);
        smallBang.setmListener(new SmallBangListener() {
            @Override

            //this method is used to start the animation manually
            public void onAnimationStart() {
            }

            @Override
            public void onAnimationEnd() {
                fragmentLikeBinding.viewpager.setCurrentItem(getLikeItem(+1),true);
                fragmentLikeBinding.heart.setImageResource(R.drawable.heart_round);
            }
        });
    }

    /**
     * Trigger the event listener action for  profile edit button.
     *
     * @param followModel Get the model of Follow Fragment
     * @return View.OnClickListener OnClickListener of the profile edit click button
     */
    public View.OnClickListener followBtnClick(final FollowModel followModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                followModel.setToFollowOrUnfollow(true);
                followBtn(view);

            }
        };
    }

    public void followBtn(View view){
        smallBang.bang(view);
        smallBang.setmListener(new SmallBangListener() {
            @Override

            public void onAnimationStart() {
            //this method is used for smallbang animation to start the action manually

            }

            @Override
            public void onAnimationEnd() {
                fragmentFollowBinding.pager.setCurrentItem(getFollowItem(+1),true);
                fragmentFollowBinding.fheart.setImageResource(R.drawable.follow);
            }
        });
    }

    /**
     * Get position of the Follower items in view pager
     *
     * @param i Position
     * @return Next position
     */
    private int getFollowItem(int i) {
        return fragmentFollowBinding.pager.getCurrentItem() + i;
    }


    /**
     * Get position of the Like items in view pager
     *
     * @param i Position
     * @return Next position
     */
    private int getLikeItem(int i) {
        return fragmentLikeBinding.viewpager.getCurrentItem() + i;
    }
}
