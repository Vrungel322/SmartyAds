package com.example.vrungel.smartyads;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.smartyads.base.BasePresenter;

/**
 * Created by Vrungel on 22.07.2017.
 */

@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }
}
