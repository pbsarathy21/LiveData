package com.ninositsolution.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

public class NameModel extends ViewModel {

    public MutableLiveData<String> data;
    private UserRepository userRepository;
    public ObservableField<String> nameval = new ObservableField<>("");

    public NameModel() {

        userRepository= new UserRepository();
        nameval.set("This is first one");
        data = userRepository.getResponse();
    }

    public MutableLiveData<String> getData()
    {
        return data;
    }

}
