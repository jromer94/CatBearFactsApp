package com.example.josh.catbearfacts;


import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GetFactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GetFactFragment extends Fragment {

    TextView mTextView;

    public static GetFactFragment newInstance(String param1, String param2) {
        GetFactFragment fragment = new GetFactFragment();

        return fragment;
    }

    public GetFactFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_get_fact, container, false);
        mTextView = (TextView) view.findViewById(R.id.fact);
        new getFactTask().execute();
        return view;
    }

    private class getFactTask extends AsyncTask<Void, Void, String>{

        @Override
        protected String doInBackground(Void... params) {
            String fact = "Failed";
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://bearcatfacts.info");
            try {
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                fact = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fact;
        }

        @Override
        protected void onPostExecute(String fact){
            mTextView.setText(fact);

        }
    }




}
