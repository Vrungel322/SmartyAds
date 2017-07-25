package com.example.vrungel.smartyads.di.modules;

import android.content.Context;
import com.example.vrungel.smartyads.data.DataManager;
import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 26.01.2017.
 */

@Module public class DataModule {

  @Provides @Singleton Realm provideRealm(Context context) {
    Realm.init(context);
    return Realm.getDefaultInstance();
  }

  @Provides @Singleton DataManager provideDataManager(Realm realm) {
    return new DataManager(realm);
  }
}
