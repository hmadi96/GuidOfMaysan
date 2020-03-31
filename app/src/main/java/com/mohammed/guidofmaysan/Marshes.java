package com.mohammed.guidofmaysan;


import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.mohammed.guidofmaysan.RecyclerView.InfoRecyclerAdapterOne;
import com.mohammed.guidofmaysan.SQLitePackage.SQLiteHelper;


public class Marshes extends Hotel {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.marshes);
        Toolbar toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle(R.string.marshes);
        setSupportActionBar(toolbar);


        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_marshes);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.table_marshes),column);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);

    }

}
