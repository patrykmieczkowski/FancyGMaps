package com.mieczkowskidev.fancygmaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_classic_map)
    public void onClassicMapClick() {
        Intent intent = new Intent(MainActivity.this, ClassicMapActivity.class);
        startActivity(intent);
    }

}
