package com.example.thannathrnyuwasin.thefar.List1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.design.widget.CollapsingToolbarLayout;


import com.example.thannathrnyuwasin.thefar.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityList extends AppCompatActivity {

    private ListView listView;
    List<Dog> dogs = new ArrayList<>();
    int dataSize;
    public Dog listDog = new Dog();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initInstances();
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        //collapsing.setTitle("Love yourself");



    }



    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(MainActivityList.this, listDog);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        int resId[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8};

        String breed[] = {getString(R.string.t_img1), getString(R.string.t_img2), getString(R.string.t_img3), getString(R.string.t_img4)
                , getString(R.string.t_img5), getString(R.string.t_img6), getString(R.string.t_img7), getString(R.string.t_img8)};

        String description[] = {getString(R.string.c_img1), getString(R.string.c_img2), getString(R.string.c_img3), getString(R.string.c_img4)
                , getString(R.string.c_img5), getString(R.string.c_img6), getString(R.string.c_img7), getString(R.string.c_img8)};
        dataSize = resId.length;


        Log.d("khem", "dataSize " + resId.length);
        Log.d("khem", "breed " + resId.length);
        Log.d("khem", "description " + resId.length);



        for (int i = 0; i < dataSize; i++) {
            Log.d("khem", " " + i);
            Dog dog = new Dog(resId[i], breed[i], description[i]);
            dogs.add(dog);
        }

        listDog.setDogs(dogs);

        //Log.d("khem",listDog);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivityList.this, "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivityList.this,ShowDetailActivity.class);
            intent.putExtra("resId",listDog.getDogs().get(position).getResId());
            intent.putExtra("breed",listDog.getDogs().get(position).getBreed());
            intent.putExtra("desc",listDog.getDogs().get(position).getDescription());
            startActivity(intent);


        }
    };

}
