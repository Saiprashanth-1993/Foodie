/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.viewmodel;

import android.view.View;
import profoodies.com.profoodies.home.follow.model.FollowStatus;
import profoodies.com.profoodies.home.like.model.LikeStatus;
import xyz.hanks.library.SmallBang;

/**
 * Controller of the HomePageFragment class
 * XML view controller trigger all the even listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class HomePageController {
    SmallBang smallBang;

    /**
     * Constructor of Home Page Controller which can invoke the method directly to activity
     * Smallbang is used for button animation
     *
     * @param smallBang
     */
    public HomePageController(SmallBang smallBang) {
        this.smallBang = smallBang;
    }

    /**
     * Trigger the event listener action for  profile edit button.
     *
     * @param likeStatus Get the model of LikeFragment
     * @return View.OnClickListener OnClickListener of the profile edit click button
     */

    public View.OnClickListener favBtnClick(final LikeStatus likeStatus) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smallBang.bang(view);
                likeStatus.setLike(true);
            }
        };
    }

    /**
     * Trigger the event listener action for  profile edit button.
     *
     * @param followStatus Get the model of Follow Status
     * @return View.OnClickListener OnClickListener of the profile edit click button
     */
    public View.OnClickListener followBtnClick(final FollowStatus followStatus) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smallBang.bang(view);
                followStatus.setFollowed(true);
            }
        };
    }
}
