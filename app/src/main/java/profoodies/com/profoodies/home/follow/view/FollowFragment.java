package profoodies.com.profoodies.home.follow.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentFollowBinding;
import profoodies.com.profoodies.home.follow.model.FollowModel;
import profoodies.com.profoodies.home.viewmodel.CustomAdapter;
import profoodies.com.profoodies.home.viewmodel.HomePageController;

public class FollowFragment extends Fragment {

    FragmentFollowBinding fragmentFollowBinding;

    public FollowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentFollowBinding = DataBindingUtil.inflate(inflater,   R.layout.fragment_follow, container, false);
        return fragmentFollowBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentFollowBinding.setViewController(new HomePageController());
        fragmentFollowBinding.setFollowInfo(new FollowModel());
        ViewPager pager=(ViewPager)view.findViewById(R.id.pager);
        pager.setAdapter(new CustomAdapter(getContext()));
        CustomAdapter customAdapter=new CustomAdapter(getContext());
        pager.setAdapter(customAdapter);
    }
}
