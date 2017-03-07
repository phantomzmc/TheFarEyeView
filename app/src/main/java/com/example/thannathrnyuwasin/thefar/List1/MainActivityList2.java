package com.example.thannathrnyuwasin.thefar.List1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thannathrnyuwasin.thefar.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityList2 extends AppCompatActivity {

    private ListView listView;
    List<Dog> dogs = new ArrayList<>();
    int dataSize;
    public Dog listDog = new Dog();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initInstances();



    }



    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(MainActivityList2.this, listDog);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        int resId[] = {R.drawable.s_img1,R.drawable.s_img2,R.drawable.s_img3,R.drawable.s_img4,R.drawable.s_img5,R.drawable.s_img6
                ,R.drawable.s_img7,R.drawable.s_img8,R.drawable.s_img9,R.drawable.s_img10};

        String breed[] = {getString(R.string.s_img1), getString(R.string.s_img2), getString(R.string.s_img3), getString(R.string.s_img4)
                , getString(R.string.s_img5), getString(R.string.s_img6), getString(R.string.s_img7), getString(R.string.s_img8),getString(R.string.s_img9)
        ,getString(R.string.s_img10)};

        String description[] = {getString(R.string.p_img1), getString(R.string.p_img2), getString(R.string.p_img3), getString(R.string.p_img4)
                , getString(R.string.p_img5), getString(R.string.p_img6), getString(R.string.p_img7), getString(R.string.p_img8),getString(R.string.p_img9),getString(R.string.p_img10)};
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
            Toast.makeText(MainActivityList2.this, "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivityList2.this,ShowDetailActivity.class);
            intent.putExtra("resId",listDog.getDogs().get(position).getResId());
            intent.putExtra("breed",listDog.getDogs().get(position).getBreed());
            intent.putExtra("desc",listDog.getDogs().get(position).getDescription());
            startActivity(intent);


        }
    };

}
