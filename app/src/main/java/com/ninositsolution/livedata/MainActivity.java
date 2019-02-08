package com.ninositsolution.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ninositsolution.livedata.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NameModel nameModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        nameModel = ViewModelProviders.of(this).get(NameModel.class);

        binding.setNamemodel(nameModel);

        nameModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                binding.myText.setText(s);
            }
        });

        binding.setPresenter(new Presenter() {
            @Override
            public void getData() {
                //nameModel.data.setValue("This is very first approach of data binding");
                nameModel.data.setValue("This is second one");
            }
        });
    }

}
