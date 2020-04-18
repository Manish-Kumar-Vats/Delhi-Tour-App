package android.example.tourguideapp;



import android.content.Intent;
import android.example.tourguideapp.adapters.ImageAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView toolbarOptionImage;
    NavigationView navigationView;
    Button eatAndDrinksBtn,funActivityBtn,monumentsBtn,shoppingBtn;
    int currentPage = 0;
    Timer timer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarOptionImage=findViewById(R.id.menu);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        eatAndDrinksBtn=findViewById(R.id.eatAndDrink);
        funActivityBtn=findViewById(R.id.funActivities);
        monumentsBtn=findViewById(R.id.monuments);
        shoppingBtn=findViewById(R.id.shopping);

        toolbarOptionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!drawerLayout.isDrawerOpen(Gravity.LEFT)) drawerLayout.openDrawer(Gravity.LEFT);
                else drawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });

        SpringDotsIndicator dotsIndicator = (SpringDotsIndicator) findViewById(R.id.dots_indicator);
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPager);
        int[] imageList= new int[]{R.drawable.akshardham_mandir,R.drawable.bara_gumbad_mosque_lodii,R.drawable.india_gate,R.drawable.jama_masjid,R.drawable.rashtrapati_bhavan};
        ImageAdapter adapterView = new ImageAdapter(this,imageList);
        mViewPager.setAdapter(adapterView);
        dotsIndicator.setViewPager(mViewPager);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        OverScrollDecoratorHelper.setUpOverScroll(scrollView);

        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1000, 2000);

        eatAndDrinksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,EatAndDrinksActivity.class));
            }
        });

        shoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShoppingActivity.class));
            }
        });

        monumentsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MonumentsActivity.class));
            }
        });

        funActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FunActivitiesActivity.class));
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.drawer_home:
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_food:
                        startActivity(new Intent(MainActivity.this, EatAndDrinksActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_shopping:
                        startActivity(new Intent(MainActivity.this, ShoppingActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_monuments:
                        startActivity(new Intent(MainActivity.this, MonumentsActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_funactivity:
                        startActivity(new Intent(MainActivity.this, FunActivitiesActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

}
