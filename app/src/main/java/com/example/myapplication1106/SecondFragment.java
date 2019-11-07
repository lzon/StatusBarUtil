package com.example.myapplication1106;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.leaf.library.StatusBarUtil;


/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class SecondFragment extends Fragment {

    private int position = -1;

    public static SecondFragment newInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("extra", position);
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_fragment, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            position = getArguments().getInt("extra");
        }

        Toolbar mToolbar = view.findViewById(R.id.toolbar);
        TextView textView = view.findViewById(R.id.txt);
        LinearLayout container = view.findViewById(R.id.container);

        StatusBarUtil.setTransparentForWindow(getActivity());
        switch (position) {
            case 0:
                StatusBarUtil.setPaddingTop(getActivity(), mToolbar);
                mToolbar.setBackgroundColor(AppUtils.getColor(R.color.end_blue));

                container.setBackground(AppUtils.getDrawable(R.mipmap.photo2));
                textView.setText("Second fragment");
                break;
            case 1:
                StatusBarUtil.setPaddingTop(getActivity(), mToolbar);
                mToolbar.setBackgroundColor(AppUtils.getColor(R.color.colorPrimaryDark));

                container.setBackground(AppUtils.getDrawable(R.mipmap.photo3));
                textView.setText("Third fragment");
                break;
            case 2:
                StatusBarUtil.setPaddingTop(getActivity(), mToolbar);
                mToolbar.setBackgroundColor(AppUtils.getColor(R.color.black));

                container.setBackground(AppUtils.getDrawable(R.mipmap.photo4));
                textView.setText("Fourth fragment");
                break;
            default:
                break;
        }

    }
}
