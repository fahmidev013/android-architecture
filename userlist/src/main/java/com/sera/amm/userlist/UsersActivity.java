package com.sera.amm.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.sera.amm.mvp.MvpActivity;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

public class UsersActivity extends MvpActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_git_hub_users);
  }

}
