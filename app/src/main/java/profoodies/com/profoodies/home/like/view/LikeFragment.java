package profoodies.com.profoodies.home.like.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentLikeBinding;
import profoodies.com.profoodies.home.like.model.LikeModel;
import profoodies.com.profoodies.home.viewmodel.HomePageController;
import xyz.hanks.library.SmallBang;

/**
 * Created by Contus team on 24/3/17.
 */

public class LikeFragment extends Fragment {

    FragmentLikeBinding fragmentLikeBinding;
    SmallBang smallBang;

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
        fragmentLikeBinding.setViewController(new HomePageController(smallBang));
        fragmentLikeBinding.setLikeInfo(new LikeModel());
    }
}

