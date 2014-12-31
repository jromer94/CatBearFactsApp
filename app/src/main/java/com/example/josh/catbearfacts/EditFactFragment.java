package com.example.josh.catbearfacts;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFactFragment extends Fragment {
    private static final String ARG_FACT = "fact";
    private static final String ARG_MESSAGE = "message";

    private String mFact;
    private String mMessage;

    public static EditFactFragment newInstance(String fact, String message) {
        EditFactFragment fragment = new EditFactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FACT, fact);
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    public EditFactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFact = getArguments().getString(ARG_FACT);
            mMessage = getArguments().getString(ARG_MESSAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_fact, container, false);
        return view;
    }


}
