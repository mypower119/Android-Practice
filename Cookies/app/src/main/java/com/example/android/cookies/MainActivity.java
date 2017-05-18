package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String TAG = this.getClass().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCookie(View view) {
        TextView textStatus = (TextView) findViewById(R.id.text_status);
        ImageView imageAndroidCookie = (ImageView) findViewById(R.id.image_android_cookie);
        textStatus.setText("I'm so full");
        imageAndroidCookie.setImageResource(R.drawable.after_cookie);

        Log.i("bó tay", "information tag");
    }
}
