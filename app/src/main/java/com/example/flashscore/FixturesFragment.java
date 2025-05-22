package com.example.flashscore;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FixturesFragment extends Fragment {

    public FixturesFragment() {
        // Bắt buộc: Constructor rỗng
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Gắn layout XML với Fragment này
        return inflater.inflate(R.layout.fragment_fixtures, container, false);
    }
}
