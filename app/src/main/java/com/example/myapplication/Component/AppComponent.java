package com.example.myapplication.Component;


import com.example.myapplication.Module.AppModule;
import com.example.myapplication.Module.RetrofitModule;
import com.example.myapplication.Module.Screen1Module;
import com.example.myapplication.Retrofit.APIInterface;
import com.example.myapplication.SampleApplicationClass;
import com.example.myapplication.Scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class, RetrofitModule.class, Screen1Module.class})
public interface AppComponent {

    APIInterface getAPIInterface();

    void inject(SampleApplicationClass sampleApplicationClass);
}
