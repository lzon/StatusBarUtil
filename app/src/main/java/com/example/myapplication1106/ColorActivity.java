package com.example.myapplication1106;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.leaf.library.StatusBarUtil;

import java.util.Random;

/**
 * @author：created by leaf on 2019/5/23
 * Github地址：https://github.com/Ye-Miao
 * Desc:
 */
public class ColorActivity extends AppCompatActivity {

    private int mColor;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_color);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        Button mChangeColor = findViewById(R.id.change_color);
        TextView mVersionText = findViewById(R.id.version_text);

        StatusBarUtil.setColor(this, AppUtils.getColor(R.color.start_blue));

        mChangeColor.setOnClickListener(v -> {
            Random random = new Random();
            mColor = 0xff000000 | random.nextInt(0xffffff);
            mToolbar.setBackgroundColor(mColor);
            StatusBarUtil.setColor(ColorActivity.this, mColor);
        });

        mVersionText.setText(
                "手机厂商：" + AppUtils.getDeviceBrand() + "\n" +
                        "手机型号：" + AppUtils.getSystemModel() + "\n" +
                        "Android系统版本号：" + AppUtils.getSystemVersion()
        );
    }
}
