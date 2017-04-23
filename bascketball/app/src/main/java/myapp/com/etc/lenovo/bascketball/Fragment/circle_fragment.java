package myapp.com.etc.lenovo.bascketball.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import myapp.com.etc.lenovo.bascketball.R;

/**
 * Created by lenovo on 2017/4/21.
 */
public class circle_fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_circle, container, false);
    }
}
