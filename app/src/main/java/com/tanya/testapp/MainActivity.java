package com.tanya.testapp;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);

        ActionBar.Tab tab = actionBar.newTab()
                .setIcon(R.drawable.chat)
                .setTabListener(new TabListener<>(
                        this, "chat", ChatFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setIcon(R.drawable.user_male_blue)
                .setTabListener(new TabListener<>(
                        this, "contacts", UsersFragment.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab()
                .setIcon(R.drawable.tag_blue)
                .setTabListener(new TabListener<>(
                        this, "notes", NotesFragment.class));
        actionBar.addTab(tab);
    }

}
