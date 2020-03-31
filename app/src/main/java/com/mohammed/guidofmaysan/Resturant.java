package com.mohammed.guidofmaysan;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;


import com.mohammed.guidofmaysan.RecyclerView.InfoModel;
import com.mohammed.guidofmaysan.RecyclerView.InfoRecyclerAdapterOne;
import com.mohammed.guidofmaysan.SQLitePackage.SQLiteHelper;

import java.util.List;


public class Resturant extends Hotel {

    public SQLiteHelper sqLiteHelper;
    public RecyclerView personRecycler;
    public InfoRecyclerAdapterOne personRecyclerAdapter;
    public List<InfoModel> infoModels;
    public RecyclerView.LayoutManager layoutManager;
    private boolean shouldLoadMore = true;
    LinearLayout footerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resturant);

        Toolbar toolbar = findViewById(R.id.mainToolbar);
        toolbar.setTitle(R.string.resturant);
        setSupportActionBar(toolbar);
       footerLayout = findViewById(R.id.footerLayout);

      /*  layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_resturant);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.table_resturant),column);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);

       */
        initViews();

      loadFirstPage();
    }
    private void initViews() {
        layoutManager = new LinearLayoutManager(this);
        personRecycler = findViewById(R.id.recycler_resturant);
        personRecycler.setLayoutManager(layoutManager);
        sqLiteHelper = new SQLiteHelper(this);

        personRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                if (dy > 0) {
                    if (linearLayoutManager.findLastCompletelyVisibleItemPosition() == infoModels.size() - 1) {
                        if (shouldLoadMore) {
                            loadMore();
                        }
                    }
                }

            }
        });

    }

    private void loadMore() {
       footerLayout.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                infoModels.addAll(sqLiteHelper.getAll(getResources().getString(R.string.table_resturant),column).subList(5, 12));
                personRecyclerAdapter.notifyDataSetChanged();
                if (infoModels.size() == sqLiteHelper.getAll(getResources().getString(R.string.table_resturant),column).size()) {
                    shouldLoadMore = false;
                }
               footerLayout.setVisibility(View.GONE);
            }
        }, 1000);
    }

    public void loadFirstPage() {
        shouldLoadMore = true;
        infoModels = sqLiteHelper.getAll(getResources().getString(R.string.table_resturant),column).subList(0, 5);
        personRecyclerAdapter = new InfoRecyclerAdapterOne(infoModels,this);
        personRecycler.setAdapter(personRecyclerAdapter);
    }

}
