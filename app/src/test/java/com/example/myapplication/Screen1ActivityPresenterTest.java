package com.example.myapplication;

import com.example.myapplication.Model.Example;
import com.example.myapplication.Retrofit.APIInterface;
import com.example.myapplication.View.Screen1Activity;
import com.example.myapplication.View.Screen1ActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Screen1ActivityPresenterTest {

    @Mock
    private Screen1Activity screen1Activity;

    @Mock
    private List<Example> resList;

    @Mock
    private APIInterface apiInterface;

    private Screen1ActivityPresenter presenter;

    @Before
    public void setup(){
        presenter = new Screen1ActivityPresenter(screen1Activity);

        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @Test

    public void getRestaurantsList_callback(){

        presenter.getRestaurantsList();

        verify(apiInterface).getRestaurantsList();
        verify(screen1Activity).getRestaurantsListData(resList);

        verify(screen1Activity,times(1)).getRestaurantsListData(resList);

        verify(screen1Activity).showErrorMessage();

    }
}
