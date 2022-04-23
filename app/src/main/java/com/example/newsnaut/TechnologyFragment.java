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

public class TechnologyFragment extends Fragment {
    String api="99120de0188446c0850bb52ce4257f54";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerViewoftechnology;
    private String category="technology";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.technologyfragement,null);

        recyclerViewoftechnology=v.findViewById(R.id.recyclerviewoftechnology);
        modelClassArrayList=new ArrayList<>();
        recyclerViewoftechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewoftechnology.setAdapter(adapter);
        findNews();
        return v;
    }
    private void findNews(){

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<fetchMainNews>() {
            @Override
            public void onResponse(Call<fetchMainNews> call, Response<fetchMainNews> response) {
                if (response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<fetchMainNews> call, Throwable t) {

            }
        });


    }
}
