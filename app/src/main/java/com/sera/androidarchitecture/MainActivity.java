package com.sera.androidarchitecture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sera.amm.mvp.MvpActivity;

public class MainActivity extends MvpActivity {


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    super.get("It works!");
  }





}
