package com.example.myapplication.Module;


import com.example.myapplication.Scope.ActivityScope;
import com.example.myapplication.View.Screen1Activity;
import com.example.myapplication.View.Screen1ActivityPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class Screen1Module {

    private Screen1Activity screen1Activity;

    public Screen1Module(Screen1Activity screen1Activity){
        this.screen1Activity = screen1Activity;
    }

    @ActivityScope
    @Provides
    Screen1Activity providesScreen1Activity(){
        return screen1Activity;
    }

    @ActivityScope
    @Provides
    Screen1ActivityPresenter providesScreen1ActivityPresenter(){
        return  new Screen1ActivityPresenter(screen1Activity);
    }
}
