package com.example.vrungel.smartyads;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.vrungel.smartyads.data.UserModel;
import java.util.List;

/**
 * Created by Vrungel on 22.07.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends MvpView {

  void fillRV(List<UserModel> userModels);

  void setUpUi();
}
