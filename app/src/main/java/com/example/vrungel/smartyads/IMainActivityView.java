package com.example.vrungel.smartyads;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

/**
 * Created by Vrungel on 22.07.2017.
 */


@StateStrategyType(AddToEndSingleStrategy.class) public interface IMainActivityView
    extends MvpView {

}
