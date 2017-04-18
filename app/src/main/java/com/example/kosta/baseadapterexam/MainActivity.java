package com.example.kosta.baseadapterexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.kosta.baseadapterexam.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList;
    private PersonAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personList = new ArrayList<>();
        generateData();
        ListView listview = (ListView)findViewById(R.id.list);

        adapter = new PersonAdapter(this, personList);

        listview.setAdapter(adapter);



    }

    private void generateData(){
        for(int i = 0; i<100; i++){
            Person p = new Person();
            p.setName("Name: "+ i);
            p.setPhone("Phone: "+ "010..." + i);
            p.setAddress("Address: "+ "Seoul" + i);

            personList.add(p);

        }
    }
}
