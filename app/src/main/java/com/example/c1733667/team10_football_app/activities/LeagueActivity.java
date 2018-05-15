package com.example.c1733667.team10_football_app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.c1733667.team10_football_app.R;
import com.example.c1733667.team10_football_app.classpack.Navigation;
import com.example.c1733667.team10_football_app.classpack.ThemeSetting;

import java.util.Map;

public class LeagueActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    private SharedPreferences sharedPreferences;
    private ListViewCompat listViewCompat;
    private String[] leagueArray;
    private Intent intent;
    private Toolbar toolbar;
    private DrawerLayout navDrawer;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences pref1 = getSharedPreferences("High contrast", 0);
        ThemeSetting leagueSetting = new ThemeSetting(pref1,LeagueActivity.this);
        leagueSetting.setHighContrast(R.layout.activity_league_outer);
        String league = this.getIntent().getStringExtra("league");
        toolbar = findViewById(R.id.my_toolbar);
<<<<<<< HEAD
=======
        if (league != null) {
            toolbar.setTitle(league);
        }


>>>>>>> e8c80046fe605909ba7119935eaff974f29176d3

        LeagueType(league);

        ArrayAdapter<String> leagueAdapter;
        leagueAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, leagueArray);
        listViewCompat = findViewById(R.id.leagueList);
        listViewCompat.setChoiceMode(ListViewCompat.CHOICE_MODE_MULTIPLE);

        ThemeSetting lv = new ThemeSetting(pref1, LeagueActivity.this);
        lv.setListView(R.id.leagueList, leagueAdapter);

        setSupportActionBar(toolbar);
        this.navDrawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, navDrawer, toolbar, R.string.open, R.string.close);
        navDrawer.addDrawerListener(toggle);
        toggle.syncState();
        this.navView = findViewById(R.id.nav_view);
        this.navView.setNavigationItemSelectedListener(this);

        listViewCompat.setOnItemClickListener(this);
        listViewCompat.setOnItemLongClickListener(this);

        Map map = sharedPreferences.getAll();
        for (Object key : map.keySet()) {
            listViewCompat.setItemChecked(Integer.valueOf((String) key), (Boolean) map.get((String) key));
        }

        NavigationView navigationView = navView;
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Navigation navigation = new Navigation(item, LeagueActivity.this);
                navigation.activityNavigation(getApplicationContext());
                return false;
            }
        });
    }

    private void LeagueType(String league) {
        if (league != null) {
            toolbar.setTitle(league);
        }
        if (league.equals("Premier League")) {
            leagueArray = getResources().getStringArray(R.array.PremierLeagueTeams);
            sharedPreferences = getSharedPreferences("premierPreference", Context.MODE_PRIVATE);
        }
        if (league.equals("Champion League")) {
            leagueArray = getResources().getStringArray(R.array.EFLC);
            sharedPreferences = getSharedPreferences("championPreference", Context.MODE_PRIVATE);
        }
        if (league.equals("League One")) {
            leagueArray = getResources().getStringArray(R.array.EFL1);
            sharedPreferences = getSharedPreferences("leagueOnePreference", Context.MODE_PRIVATE);
        }
        if (league.equals("League Two")) {
            leagueArray = getResources().getStringArray(R.array.EFL2);
            sharedPreferences = getSharedPreferences("leagueTwoPreference", Context.MODE_PRIVATE);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, String.format("Item clicked on = %d", position), Toast.LENGTH_SHORT).show();
        SparseBooleanArray checkeditems = listViewCompat.getCheckedItemPositions();
        sharedPreferences.edit().putBoolean(String.valueOf(position), checkeditems.get(position)).commit();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        intent = new Intent(getApplicationContext(), InfoActivity.class);
        intent.putExtra("Club Name", leagueArray[position]);
        startActivity(intent);
        return true;
    }
}
