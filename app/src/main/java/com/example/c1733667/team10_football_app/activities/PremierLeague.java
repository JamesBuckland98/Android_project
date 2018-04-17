package com.example.c1733667.team10_football_app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.support.design.widget.NavigationView;

import com.example.c1733667.team10_football_app.R;

import java.util.Map;

public class PremierLeague extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, NavigationView.OnNavigationItemSelectedListener {
    private String[] premierLeague;
    private Intent intent;
    private SharedPreferences sharedPreferences;
    private ListViewCompat lv;

    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //event handling thing majig
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premier_league_outer);

        sharedPreferences = getSharedPreferences("PremierPreference", Context.MODE_PRIVATE);

        ArrayAdapter<String> premierAdapter;
        premierLeague = getResources().getStringArray(R.array.PremierLeagueTeams);
        premierAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, premierLeague);
        lv = findViewById(R.id.premierList);
        lv.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(premierAdapter);
        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,navDrawer,toolbar,R.string.open,R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);


        Map map = sharedPreferences.getAll();
        for(Object key : map.keySet()){
            lv.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.stad:
                        Intent intent = new Intent(PremierLeague.this, StadiumActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.scores:
                        Intent intent1 = new Intent(PremierLeague.this, Score.class);
                        startActivity(intent1);
                        break;



                    case R.id.maps:
                        Intent intent2 = new Intent(PremierLeague.this, MapsActivity.class);
                        startActivity(intent2);
                        break;



                    case R.id.exit:
                        System.exit(0);


                    case R.id.home:
                        Intent intent3 = new Intent(PremierLeague.this, MainActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.achievements:
                        Intent intent4 = new Intent(PremierLeague.this, Achievement.class);
                        startActivity(intent4);
                        break;

                    case R.id.help:
                        Intent intent5 = new Intent(PremierLeague.this, HelpActivity.class);
                        startActivity(intent5);
                        break;

                }
                return false;
            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();

        SparseBooleanArray checkeditems = lv.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", premierLeague[position]);
        startActivity(intent);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}