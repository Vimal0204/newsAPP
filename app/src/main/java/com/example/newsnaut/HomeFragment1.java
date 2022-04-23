package com.example.newsnaut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment1 extends Fragment {

    String api="99120de0188446c0850bb52ce4257f54";
    ArrayList<ModelClass1> modelClassArrayList1;
    Adapter1 adapter1;
    String country="uk";
    private RecyclerView recyclerViewofhome1;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.homefragment1,null);
        recyclerViewofhome1=view.findViewById(R.id.recyclerviewofhome1);
        modelClassArrayList1=new ArrayList<>();
        recyclerViewofhome1.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter1=new Adapter1(getContext(),modelClassArrayList1);
        recyclerViewofhome1.setAdapter(adapter1);
        findNews1();
        return view;
    }
    private void findNews1(){
        ApiUtilities1.getApiInterface1().getNews1(country,100,api).enqueue(new Callback<interNews>() {
            @Override
            public void onResponse(Call<interNews> call, Response<interNews> response) {
                if (response.isSuccessful())
                {
                    modelClassArrayList1.addAll(response.body().getArticles());
                    adapter1.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<interNews> call, Throwable t) {

            }
        });
    }


}


