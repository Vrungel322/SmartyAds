package com.example.vrungel.smartyads;

import android.app.Application;
import com.example.vrungel.smartyads.di.components.AppComponent;
import com.example.vrungel.smartyads.di.components.DaggerAppComponent;
import com.example.vrungel.smartyads.di.modules.AppModule;
import timber.log.Timber;

/**
 * Created by Vrungel on 22.07.2017.
 */

public class App extends Application {

  private static AppComponent sAppComponent;

  public static AppComponent getAppComponent() {
    return sAppComponent;
  }

  @Override public void onCreate() {
    super.onCreate();

    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }

    sAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
  }
}

