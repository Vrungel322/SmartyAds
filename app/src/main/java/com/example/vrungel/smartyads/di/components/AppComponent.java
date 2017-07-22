package com.example.vrungel.smartyads.di.components;


import com.example.vrungel.smartyads.di.modules.AppModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Vrungel on 25.01.2017.
 */
@Singleton @Component(modules = AppModule.class) public interface AppComponent {


  //presenters
  //void inject(MainActivityPresenter presenter);


}
