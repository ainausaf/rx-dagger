package com.example.myapplication.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.myapplication.Component.AppComponent;
import com.example.myapplication.Component.DaggerScreen1Component;
import com.example.myapplication.Component.Screen1Component;
import com.example.myapplication.Model.Example;
import com.example.myapplication.Module.Screen1Module;
import com.example.myapplication.R;
import com.example.myapplication.Retrofit.APIInterface;
import com.example.myapplication.SampleApplicationClass;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Screen1Activity extends AppCompatActivity {

    @BindView(R.id.recylerView_sample)
    RecyclerView recyclerView;

    private AppComponent appComponent;

    private Screen1Component screen1Component;

    @Inject
    public APIInterface apiInterface;

    @Inject
    public Screen1ActivityPresenter screen1ActivityPresenter;

    ArrayList<Example> restaurantList;

    MainAdapter mainAdapter;
    @Override
    public void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.sample_activity);
        ButterKnife.bind(this);
        initDagger();

        initRecylerView();
        screen1ActivityPresenter.onCreate(apiInterface);
    }

    private void initRecylerView() {
        restaurantList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        mainAdapter = new MainAdapter(this,restaurantList);
        recyclerView.setAdapter(mainAdapter);
    }


    private void initDagger() {
        appComponent = ((SampleApplicationClass)getApplication()).getAppComponent();
        if(screen1Component == null) {
            screen1Component = DaggerScreen1Component.builder()
                    .screen1Module(new Screen1Module(this))
                    .appComponent(appComponent)
                    .build();
            screen1Component.inject(this);
        }
    }

    public void showErrorMessage() {

        Toast toast = Toast.makeText(this,"there is an error", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void getRestaurantsListData(List<Example> examples) {
        restaurantList.addAll(examples);
        mainAdapter.addAll(restaurantList);
    }
}
