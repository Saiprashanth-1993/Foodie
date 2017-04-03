/*
 * @category ProFoodies
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package profoodies.com.profoodies.home.follow.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentFollowBinding;
import profoodies.com.profoodies.home.follow.model.FollowModel;
import profoodies.com.profoodies.home.viewmodel.CustomFollowAdapter;
import profoodies.com.profoodies.home.viewmodel.HomePageController;
import profoodies.com.profoodies.home.viewmodel.SingleSideSwipeableViewPager;
import xyz.hanks.library.SmallBang;

/**
 * Fragment to display user profile and follow option with coins
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class FollowFragment extends Fragment {

    /**
     * Activity FollowFragment Binding for initializing the layout as data binding.
     */
    FragmentFollowBinding fragmentFollowBinding;

    SmallBang smallBang;

    public FollowFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFollowBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_follow, container, false);
        smallBang = SmallBang.attach2Window(getActivity());
        return fragmentFollowBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentFollowBinding.pager.setAllowedSwipeDirection(SingleSideSwipeableViewPager.SwipeDirection.RIGHT);
        fragmentFollowBinding.setViewController(new HomePageController(smallBang, fragmentFollowBinding));
        fragmentFollowBinding.setFollowInfo(new FollowModel());
        CustomFollowAdapter customFollowAdapter = new CustomFollowAdapter(getContext());
        fragmentFollowBinding.pager.setAdapter(customFollowAdapter);
    }
}
