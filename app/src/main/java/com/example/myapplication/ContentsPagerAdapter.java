package com.example.myapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Fragment.FeedFragment;
import com.example.myapplication.Fragment.HomeFragment;
import com.example.myapplication.Fragment.MeetingFragment;
import com.example.myapplication.Fragment.SettingFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount){
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case 1:
                MeetingFragment meetingFragment = new MeetingFragment();
                return meetingFragment;

            case 2:
                FeedFragment feedFragment = new FeedFragment();
                return feedFragment;

            case 3:
                SettingFragment settingFragment = new SettingFragment();
                return settingFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
