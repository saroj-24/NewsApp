package com.example.newsapp;

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

    final  String API  = "436b294a128344c8a10bac125f691ef8";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="in";
    private RecyclerView recyclerViewoftechnology;
    String category="technology";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View homeview =  inflater.inflate(R.layout.technologyfragment,null); //  connecting home fragment

        recyclerViewoftechnology = homeview.findViewById(R.id.recycleviewoftechnology);
        modelClassArrayList= new ArrayList<>();
        recyclerViewoftechnology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewoftechnology.setAdapter(adapter);

        findNews();


        return  homeview;

    }
    private  void findNews()
    {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,API).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}