package com.example.myapplication;

import android.app.Application;
import android.content.Context;

import com.example.myapplication.Component.AppComponent;
import com.example.myapplication.Module.AppModule;
import com.example.myapplication.Component.DaggerAppComponent;

public class SampleApplicationClass extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
