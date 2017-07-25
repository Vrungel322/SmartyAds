package com.example.vrungel.smartyads;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.smartyads.base.BaseActivity;
import com.example.vrungel.smartyads.data.UserModel;
import java.util.List;

public class MainActivity extends BaseActivity implements IMainActivityView {

  @InjectPresenter MainActivityPresenter mainActivityPresenter;

  @BindView(R.id.rvUsers) RecyclerView mRecyclerViewUsers;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
  }

  @Override public void fillRV(List<UserModel> userModels) {
    mRecyclerViewUsers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    UserAdapter userAdapter = new UserAdapter();
    userAdapter.addListUserModels(userModels);
    mRecyclerViewUsers.setAdapter(userAdapter);
  }
}
