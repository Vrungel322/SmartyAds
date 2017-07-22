package com.example.vrungel.smartyads.di.components;


import com.example.vrungel.smartyads.MainActivityPresenter;
import com.example.vrungel.smartyads.base.BaseActivity;
import com.example.vrungel.smartyads.base.BaseFragment;
import com.example.vrungel.smartyads.di.modules.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 25.01.2017.
 */
@Singleton @Component(modules = AppModule.class) public interface AppComponent {
  void inject(BaseActivity baseActivity);

  void inject(BaseFragment baseFragment);

  void inject(MainActivityPresenter mainActivityPresenter);

}
