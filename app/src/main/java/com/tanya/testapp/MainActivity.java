package com.tanya.testapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    ViewPager mViewPager;
    TabLayout mTabs;
//    PagerAdapter mTabsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

//        mViewPager = (ViewPager) findViewById(R.id.pager);

        mTabs = (TabLayout)findViewById(R.id.tabs) ;
        mTabs.addTab(mTabs.newTab().setIcon(R.drawable.chat_blue).setTag(ChatFragment.class));
        mTabs.addTab(mTabs.newTab().setIcon(R.drawable.user_male_blue).setTag(UsersFragment.class));
        mTabs.addTab(mTabs.newTab().setIcon(R.drawable.tag_blue).setTag(NotesFragment.class));

        mTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, getFragment(tab))
                    .addToBackStack(null)
                    .commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, getFragment(mTabs.getTabAt(0)))
                .addToBackStack(null)
                .commit();;

//        mTabsAdapter = new PagerAdapter(this, mViewPager, mTabs);
//        mTabsAdapter.addTab(mTabs.newTab().setText("Tab1").setIcon(R.drawable.chat_blue),
//                ChatFragment.class, null);
//        mTabsAdapter.addTab(mTabs.newTab().setText("Tab2").setIcon(R.drawable.user_male_blue),
//                UsersFragment.class, null);
//        mTabsAdapter.addTab(mTabs.newTab().setText("Tab3").setIcon(R.drawable.tag_blue),
//                NotesFragment.class, null);
//
//        mViewPager.setAdapter(mTabsAdapter);
//        mTabs.setupWithViewPager(mViewPager);
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));


        Toolbar toolbarBottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        toolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_settings:
                        // TODO
                        break;
                    // TODO: Other cases
                }
                return true;
            }
        });
        // Inflate a menu to be displayed in the toolbar
//        toolbarBottom.inflateMenu(R.menu.menu_main);
    }

    private Fragment getFragment(TabLayout.Tab tab){
        Class<?> clss = (Class<?>) tab.getTag();
        return Fragment.instantiate(mContext, clss.getName(), null);
    }


}
