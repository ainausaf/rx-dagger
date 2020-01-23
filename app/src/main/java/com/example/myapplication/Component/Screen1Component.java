package com.example.myapplication.Component;



import com.example.myapplication.Module.Screen1Module;
import com.example.myapplication.Scope.ActivityScope;
import com.example.myapplication.View.Screen1Activity;

import dagger.Component;

@ActivityScope
@Component(modules = Screen1Module.class,dependencies = AppComponent.class)
public interface Screen1Component {

    void inject(Screen1Activity screen1Activity);
}
