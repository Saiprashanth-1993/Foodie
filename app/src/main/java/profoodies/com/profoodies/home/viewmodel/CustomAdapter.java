package profoodies.com.profoodies.home.viewmodel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import profoodies.com.profoodies.R;

/**
 * Created by Contus team on 27/3/17.
 */

public class CustomAdapter extends PagerAdapter {

    Context context;

    LayoutInflater inflater;

    public CustomAdapter(Context context){
        this.context=context;
         inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View vi = inflater.inflate(R.layout.fragment_pager, container, false);
        return vi;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
