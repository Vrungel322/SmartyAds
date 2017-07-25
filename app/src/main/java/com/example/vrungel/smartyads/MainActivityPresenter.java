package com.example.vrungel.smartyads;

import com.arellomobile.mvp.InjectViewState;
import com.example.vrungel.smartyads.base.BasePresenter;
import com.example.vrungel.smartyads.data.UserModel;
import rx.Subscription;
import timber.log.Timber;

/**
 * Created by Vrungel on 22.07.2017.
 */

@InjectViewState public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

  @Override protected void onFirstViewAttach() {
    super.onFirstViewAttach();
    mDataManager.fillRealmDB();
    //checkItemsInDB();
    setUpUi();
  }

  private void setUpUi() {
    getViewState().setUpUi();
    Subscription subscription = mDataManager.getWithLimitOffset(UserModel.class,0,15)
        //.compose(ThreadSchedulers.applySchedulers())
        .subscribe(userModels -> {
          getViewState().fillRV(userModels);
        });
    addToUnsubscription(subscription);
  }

  public void loadOneMorePage(int offset, int limit){
    Subscription subscription = mDataManager.getWithLimitOffset(UserModel.class,offset,limit)
        //.compose(ThreadSchedulers.applySchedulers())
        .subscribe(userModels -> {
          getViewState().fillRV(userModels);
        });
    addToUnsubscription(subscription);
  }

  private void checkItemsInDB() {
    Subscription subscription = mDataManager.getAll(UserModel.class)
        //.compose(ThreadSchedulers.applySchedulers())
        .subscribe(userModels -> {
          Timber.e(String.valueOf(userModels.size()));
        });
    addToUnsubscription(subscription);
  }

  @Override protected void inject() {
    App.getAppComponent().inject(this);
  }

  public void destroyRealm() {
    mDataManager.clearRealm();
  }
}
