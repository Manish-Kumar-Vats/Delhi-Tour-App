package android.example.tourguideapp;


import android.example.tourguideapp.adapters.MonumentsFragmentAdapter;
import android.example.tourguideapp.fragments.MonumentOneFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

public class MonumentsActivity extends AppCompatActivity {

    ImageView toolbar_menu;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monuments);

        toolbar_menu=findViewById(R.id.menu);
        toolbar_title=findViewById(R.id.title);

        toolbar_menu.setImageResource(R.drawable.ic_arrow_back_black_24dp);
        toolbar_title.setText(getString(R.string.monuments));
        toolbar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ViewPager viewPager=findViewById(R.id.fragmentContainer);
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        viewPager.setVisibility(View.VISIBLE);

        MonumentsFragmentAdapter adapter = new MonumentsFragmentAdapter(getSupportFragmentManager(),this);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
