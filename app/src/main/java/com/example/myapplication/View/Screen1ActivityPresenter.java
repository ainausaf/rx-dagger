package com.example.myapplication.View;


import com.example.myapplication.Model.Example;
import com.example.myapplication.Retrofit.APIInterface;

import java.util.List;


import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class Screen1ActivityPresenter {
    
    private Screen1Activity view;
    private APIInterface apiInterface;
    
    public Screen1ActivityPresenter(Screen1Activity screen1Activity) {
        
        view = screen1Activity;
    }

    public void onCreate(APIInterface apiInterface) {
        this.apiInterface = apiInterface;
        getRestaurantsList();
    }

    public void getRestaurantsList() {

      Observable<List<Example>> restaurantListData = apiInterface.getRestaurantsList().flatMap(Observable::just);
      restaurantListData.subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Observer<List<Example>>() {
                  @Override
                  public void onCompleted() {

                  }

                  @Override
                  public void onError(Throwable e) {
                      view.showErrorMessage();
                  }

                  @Override
                  public void onNext(List<Example> examples) {
                        view.getRestaurantsListData(examples);
                  }
              });
    }
}
