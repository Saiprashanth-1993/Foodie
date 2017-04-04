/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.like.view;

import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentLikeBinding;
import profoodies.com.profoodies.home.like.model.LikeStatus;
import profoodies.com.profoodies.home.viewmodel.CustomLikePagerAdapter;
import profoodies.com.profoodies.home.viewmodel.HomePageController;
import profoodies.com.profoodies.home.viewmodel.SingleSideSwipeableViewPager;
import profoodies.com.profoodies.interfaces.IFavouriteMedia;
import xyz.hanks.library.SmallBang;

/**
 * Fragment to display user posts and like button with coins
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class LikeFragment extends Fragment {

    private static IFavouriteMedia favouriteMedia;
    FragmentLikeBinding fragmentLikeBinding;
    SmallBang smallBang;
    Typeface typeface;

    public static LikeFragment newInstance(IFavouriteMedia favourite) {
        LikeFragment likeFragment = new LikeFragment();
        favouriteMedia = favourite;
        return likeFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLikeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_like, container, false);

        smallBang = SmallBang.attach2Window(getActivity());

        return fragmentLikeBinding.getRoot();


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentLikeBinding.viewpager.setAllowedSwipeDirection(SingleSideSwipeableViewPager.SwipeDirection.RIGHT);
        fragmentLikeBinding.setViewController(new HomePageController(smallBang, fragmentLikeBinding,favouriteMedia));
        fragmentLikeBinding.setLikeStatus(new LikeStatus());
        fragmentLikeBinding.name.setTypeface(typeface);
        CustomLikePagerAdapter customLikeAdapter = new CustomLikePagerAdapter(getContext());
        fragmentLikeBinding.viewpager.setAdapter(customLikeAdapter);

    }


}

