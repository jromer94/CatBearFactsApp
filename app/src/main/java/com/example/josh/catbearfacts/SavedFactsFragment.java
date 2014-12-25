package com.example.josh.catbearfacts;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedFactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedFactsFragment extends Fragment {

    public static SavedFactsFragment newInstance(String param1, String param2) {
        SavedFactsFragment fragment = new SavedFactsFragment();
        return fragment;
    }

    public SavedFactsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved_facts, container, false);
    }


}
