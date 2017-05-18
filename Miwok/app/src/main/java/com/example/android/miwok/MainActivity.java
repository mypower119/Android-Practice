/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        Log.i("ColorActivity", "onCreate");

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(categoryAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tablayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tablayout.setupWithViewPager(viewPager);

//        // Find the view that shows the number category
//        TextView textNumbers = (TextView) findViewById(R.id.text_numbers);
//        TextView textFamily = (TextView) findViewById(R.id.text_family);
//        TextView textPhrases = (TextView) findViewById(R.id.text_phrases);
//        TextView textColors = (TextView) findViewById(R.id.text_colors);
//
//        // Set a clicklistener on that view
//        textNumbers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent inten = new Intent(view.getContext(), NumbersActivity.class);
//                startActivity(inten);
//            }
//        });
//
//        textFamily.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent inten = new Intent(MainActivity.this, FamilyActivity.class);
//                startActivity(inten);
//            }
//        });
//
//        textPhrases.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent inten = new Intent(MainActivity.this, PhrasesActivity.class);
//                startActivity(inten);
//            }
//        });
//
//        textColors.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                navigationActivity(MainActivity.this, ColorsActivity.class);
//            }
//        });
    }

    private void navigationActivity(Context context, Class cls) {
        Intent inten = new Intent(context, cls);
        startActivity(inten);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ColorActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ColorActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ColorActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ColorActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ColorActivity", "onDestroy");
    }
}
