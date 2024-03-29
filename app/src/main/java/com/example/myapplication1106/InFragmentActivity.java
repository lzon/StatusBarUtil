package com.example.myapplication1106;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class InFragmentActivity extends AppCompatActivity {

    private int mCurrentPos = -1;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_in_fragment);

        mFragments = Arrays.asList(
                FirstFragment.newInstance(),
                SecondFragment.newInstance(0),
                SecondFragment.newInstance(1),
                SecondFragment.newInstance(2)
        );

        BottomNavigationView bottomMain = findViewById(R.id.bottom_main);
        bottomMain.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.one:
                    switchFragmentIndex(0);
                    break;
                case R.id.two:
                    switchFragmentIndex(1);
                    break;
                case R.id.three:
                    switchFragmentIndex(2);
                    break;
                case R.id.four:
                    switchFragmentIndex(3);
                    break;
                default:
                    break;
            }
            return true;
        });
        switchFragmentIndex(0);
    }

    private void switchFragmentIndex(int position) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (mCurrentPos != -1) {
            fragmentTransaction.hide(mFragments.get(mCurrentPos));
        }
        if (!mFragments.get(position).isAdded()) {
            fragmentTransaction.add(R.id.fl_content, mFragments.get(position));
        }
        fragmentTransaction.show(mFragments.get(position)).commit();
        mCurrentPos = position;
    }


}
