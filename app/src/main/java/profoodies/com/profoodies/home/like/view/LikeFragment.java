/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package profoodies.com.profoodies.home.like.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentLikeBinding;
import profoodies.com.profoodies.home.like.model.LikeModel;
import profoodies.com.profoodies.home.viewmodel.CustomLikePagerAdapter;
import profoodies.com.profoodies.home.viewmodel.HomePageController;
import xyz.hanks.library.SmallBang;

/**
 * Fragment to display user posts and like button with coins
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class LikeFragment extends Fragment {

    FragmentLikeBinding fragmentLikeBinding;
    SmallBang smallBang;

    public LikeFragment() {
    // Required empty public constructor
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
        ViewPager pager = (ViewPager) view.findViewById(R.id.viewpager);
        fragmentLikeBinding.setViewController(new HomePageController(smallBang,fragmentLikeBinding));
        fragmentLikeBinding.setLikeInfo(new LikeModel());
        CustomLikePagerAdapter customLikeAdapter = new CustomLikePagerAdapter(getContext());
        pager.setAdapter(customLikeAdapter);

    }
}

