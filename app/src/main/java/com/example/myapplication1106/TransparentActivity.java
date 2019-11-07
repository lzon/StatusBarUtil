package com.example.myapplication1106;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.leaf.library.StatusBarUtil;

/**
 * @author：created by leaf on 2019-05-07
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class TransparentActivity extends AppCompatActivity {
    private boolean isChanged;
    private RelativeLayout relativeLayout;


    @Override
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_transparent);
        StatusBarUtil.setTransparentForWindow(this);

        Button btn = findViewById(R.id.button1);
        relativeLayout = findViewById(R.id.container);

        btn.setOnClickListener(v -> {
            isChanged = !isChanged;
            if (isChanged) {
                relativeLayout.setBackground(AppUtils.getDrawable(R.mipmap.photo6));
            } else {
                relativeLayout.setBackground(AppUtils.getDrawable(R.mipmap.photo5));
            }
        });

    }
}
