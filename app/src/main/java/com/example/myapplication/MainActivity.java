package com.example.myapplication;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private Context mContext;
    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentPagerAdapter;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;
    ImageView toolbar_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews(); //findviewbyid
        initMainLayout();
    }

    private View createTabView(String string, Drawable drawable){
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView textView = tabView.findViewById(R.id.txt_name);
        ImageView imageView = tabView.findViewById(R.id.imageView);
        textView.setText(string);
        imageView.setImageDrawable(drawable);

        return tabView;
    }

    public void initMainLayout(){
        /*       Tab  Layout     */
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("홈", getDrawable(R.drawable.passion))));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("회의록", getDrawable(R.drawable.passion))));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("피드", getDrawable(R.drawable.passion))));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("설정", getDrawable(R.drawable.passion))));

        mContentPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(mContentPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout)); //페이지 바뀔때 탭 바뀌게
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { //탭이 선택될때

            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override

            public void onTabUnselected(TabLayout.Tab tab) {

            }



            @Override

            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        /*   Tool Bar   */
        setSupportActionBar(toolbar);
        toolbar_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.toolbar_icon:
                        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }else{
                            drawerLayout.openDrawer(GravityCompat.START);
                        }
                        break;
                }
            }
        });

        /*  tooggle  */

    }

    public void initViews(){
        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager)findViewById(R.id.pager_content);
        drawerLayout = findViewById(R.id.drawerlayout);
        toolbar_icon = findViewById(R.id.toolbar_icon);
    }

}
