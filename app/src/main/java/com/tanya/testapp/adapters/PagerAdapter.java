package com.tanya.testapp.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by tparnyuk on 11.06.15.
 */
public class PagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

    private Context mContext;
    private TabLayout mTabsLayout;
    private ViewPager mViewPager;
    private ArrayList<TabLayout.Tab> mTabsList = new ArrayList<>();

    public PagerAdapter(AppCompatActivity activity, ViewPager pager, TabLayout tabsLayout) {
        super(activity.getSupportFragmentManager());
        mContext = activity;
        mTabsLayout = tabsLayout;
        mViewPager = pager;
        mViewPager.setAdapter(this);
        mViewPager.addOnPageChangeListener(this);
    }

    public void addTab(TabLayout.Tab tab, Class<?> clss, Bundle args) {
        TabInfo info = new TabInfo(clss, args);
        tab.setTag(info);
        mTabsList.add(tab);
        mTabsLayout.addTab(tab);
//        mActionBar.addTab(tab);
        notifyDataSetChanged();
    }

    static final class TabInfo {
        private final Class<?> clss;
        private final Bundle args;

        TabInfo(Class<?> _class, Bundle _args) {
            clss = _class;
            args = _args;
        }
    }

    @Override
    public Fragment getItem(int position) {
        TabInfo tabInfo = (TabInfo) mTabsList.get(position).getTag();
        return Fragment.instantiate(mContext, tabInfo.clss.getName(), tabInfo.args);
    }

    @Override
    public int getCount() {
        return mTabsList.size();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mViewPager.setCurrentItem(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsList.get(position).getText();
    }



}
