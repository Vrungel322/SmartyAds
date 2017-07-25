package com.example.vrungel.smartyads;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.vrungel.smartyads.base.BaseActivity;
import com.example.vrungel.smartyads.data.UserModel;
import java.util.List;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements IMainActivityView {

  private static final int PAGINATION_SIZE = 15;
  @InjectPresenter MainActivityPresenter mainActivityPresenter;

  @BindView(R.id.rvUsers) RecyclerView mRecyclerViewUsers;
  private LinearLayoutManager mLayoutManager;
  private UserAdapter mUserAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    setContentView(R.layout.activity_main);
    super.onCreate(savedInstanceState);
  }

  @Override public void fillRV(List<UserModel> userModels) {
    mUserAdapter.addListUserModels(userModels);
  }

  @Override public void setUpUi() {
    mLayoutManager = new LinearLayoutManager(getApplicationContext());
    mRecyclerViewUsers.setLayoutManager(mLayoutManager);
    mUserAdapter = new UserAdapter();
    mRecyclerViewUsers.setAdapter(mUserAdapter);
    // Pagination
    mRecyclerViewUsers.addOnScrollListener(new RecyclerView.OnScrollListener() {
      @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = mLayoutManager.getChildCount();
        int totalItemCount = mLayoutManager.getItemCount();
        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();

        if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
            && firstVisibleItemPosition >= 0
            && totalItemCount >= PAGINATION_SIZE) {
          mainActivityPresenter.loadOneMorePage(firstVisibleItemPosition+ PAGINATION_SIZE +1,
              firstVisibleItemPosition+ PAGINATION_SIZE);
        }
      }
    });
  }
}
