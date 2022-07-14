package com.myapplicationdev.android.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText etTitle;
    TextView tvSingers;
    EditText etSingers;
    TextView tvYear;
    EditText etYear;
    TextView tvStars;
    RadioGroup rgStars;
    Button btnInsert;
    Button btnShow;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tvTitle);
        etTitle = findViewById(R.id.etTitle);
        tvSingers = findViewById(R.id.tvSingers);
        etSingers = findViewById(R.id.etSingers);
        tvYear = findViewById(R.id.tvYear);
        etYear = findViewById(R.id.etYear);
        tvStars = findViewById(R.id.tvStars);
        rgStars = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                Intent x = new Intent(MainActivity.this,
                        ShowActivity.class);
                al.addAll(dbh.getAllSongs());
                startActivity(x);


            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());

                DBHelper dbh = new DBHelper(MainActivity.this);
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton5) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("*"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("**"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton3) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("***"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("****"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton) {
                    long inserted_id = dbh.insertSong(title, singers, year, Integer.parseInt("*****"));
                    if (inserted_id != -1){
                        al.clear();
                        al.addAll(dbh.getAllSongs());
//                        aa.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Insert successful",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

}