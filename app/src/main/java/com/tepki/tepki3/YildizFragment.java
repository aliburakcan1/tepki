package com.tepki.tepki3;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class YildizFragment extends Fragment {

    Activity titleChange;

    public YildizFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //titleChange.setTitle("Tumblr");
        return inflater.inflate(R.layout.fragment_yildiz, container, false);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //titleChange = (MainActivity) activity;
    }
}
