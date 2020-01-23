package com.example.myapplication.Module;



import com.example.myapplication.SampleApplicationClass;

import dagger.Module;

@Module
public class AppModule {

    private SampleApplicationClass sampleApplicationClass;

    public AppModule(SampleApplicationClass sampleApplicationClass){
        this.sampleApplicationClass = sampleApplicationClass;
    }

}
