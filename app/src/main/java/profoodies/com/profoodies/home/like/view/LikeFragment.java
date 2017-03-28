package profoodies.com.profoodies.home.like.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import profoodies.com.profoodies.R;
import profoodies.com.profoodies.databinding.FragmentLikeBinding;

/**
 * Created by Contus team on 24/3/17.
 */

public class LikeFragment extends Fragment {

    Activity activity;

    FragmentLikeBinding fragmentLikeBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentLikeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_like, container, false);
        activity = getActivity();
        return fragmentLikeBinding.getRoot();
    }

}

