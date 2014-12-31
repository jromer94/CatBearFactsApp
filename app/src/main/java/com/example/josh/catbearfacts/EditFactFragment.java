package com.example.josh.catbearfacts;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import greendao.CatBearFact;
import greendao.CatBearFactDao;
import greendao.DaoSession;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditFactFragment extends Fragment {
    private static final String ARG_FACT_ID = "id";


    private long mId;

    private CatBearFactDao mFactDao;
    private CatBearFact mFact;

    private EditText mFactEdit;
    private EditText mMessageEdit;
    private Button mUpdateButton;
    private Button mDeleteButton;

    public static EditFactFragment newInstance(long id) {
        EditFactFragment fragment = new EditFactFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_FACT_ID, id);
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
            mId = getArguments().getLong(ARG_FACT_ID);
        }
        DaoSession session = ((MyApplication) getActivity().getApplicationContext()).getDaoSession();
        mFactDao = session.getCatBearFactDao();
        mFact = mFactDao.load(mId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_fact, container, false);

        mFactEdit = (EditText) view.findViewById(R.id.edit_fact);
        mFactEdit.setText(mFact.getName());

        mMessageEdit = (EditText) view.findViewById(R.id.edit_message);
        mMessageEdit.setText(mFact.getComment());

        mUpdateButton = (Button) view.findViewById(R.id.update_button);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mFact.setName(mFactEdit.getText().toString());
               mFact.setComment(mMessageEdit.getText().toString());
               mFactDao.update(mFact);
               getActivity().finish();
            }
        });

        mDeleteButton = (Button) view.findViewById(R.id.delete_button);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFactDao.delete(mFact);
                getActivity().finish();
            }
        });

        return view;
    }


}
