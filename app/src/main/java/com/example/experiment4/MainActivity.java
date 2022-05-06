package com.example.experiment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements PassData{
    FrameLayout fragment1,fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = findViewById(R.id.fragment1);
        fragment2 = findViewById(R.id.fragment2);
        Bundle bundle = new Bundle();
        bundle.putString("haveData","no");
        Fragment2 fragment2 = new Fragment2();
        fragment2.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment1,new Fragment1()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,fragment2).commit();

    }

    @Override
    public void sendData(String name, String branch, String year, String review) {
        Bundle bundle = new Bundle();
        bundle.putString("haveData","yes");
        bundle.putString("name",name);
        bundle.putString("branch",branch);
        bundle.putString("year",year);
        bundle.putString("review",review);
        Fragment2 fragment2 = new Fragment2();
        fragment2.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment2,fragment2).commit();

    }
}