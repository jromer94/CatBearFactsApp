package com.example.josh.catbearfacts;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import greendao.CatBearFact;
import greendao.CatBearFactDao;
import greendao.DaoSession;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SavedFactsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SavedFactsFragment extends ListFragment{

    ArrayList<CatBearFact> mFacts;

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

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume(){
        super.onResume();
        DaoSession session = ((MyApplication) getActivity().getApplicationContext()).getDaoSession();
        CatBearFactDao factDao = session.getCatBearFactDao();
        mFacts = (ArrayList<CatBearFact>) factDao.loadAll();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, factsToStrings());
        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(getActivity(), EditFactActivity.class);
        intent.putExtra("FACT_ID", mFacts.get(position).getId());
        startActivity(intent);
    }

    private ArrayList<String> factsToStrings(){
        ArrayList<String> strings = new ArrayList<String>();
        for(int i = 0; i < mFacts.size(); i++){
            strings.add(mFacts.get(i).getName());
        }
        return strings;
    }


}
