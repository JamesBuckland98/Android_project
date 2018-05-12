package com.example.c1733667.team10_football_app.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c1733667.team10_football_app.R;

/**
 * Created by c1722696 on 5/8/2018.
 */

public class FragmentToTest extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmente_to_test, null);

    }
}
