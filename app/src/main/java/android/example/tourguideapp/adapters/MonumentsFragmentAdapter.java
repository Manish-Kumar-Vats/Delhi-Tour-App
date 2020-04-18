package android.example.tourguideapp.adapters;

import android.content.Context;
import android.example.tourguideapp.fragments.MonumentFiveFragment;
import android.example.tourguideapp.fragments.MonumentFourFragment;
import android.example.tourguideapp.fragments.MonumentOneFragment;
import android.example.tourguideapp.fragments.MonumentSixFragment;
import android.example.tourguideapp.fragments.MonumentThreeFragment;
import android.example.tourguideapp.fragments.MonumentTwoFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class MonumentsFragmentAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "India Gate", "Qutub Minar", "Red Fort","Safdarjung's Fort", "Lotus Temple", "Akshardham" };
    private Context context;
    public MonumentsFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MonumentOneFragment();
        } else if (position == 1) {
            return new MonumentTwoFragment();
        } else if (position == 2) {
            return new MonumentThreeFragment();
        } else if (position == 3) {
            return new MonumentFourFragment();
        } else if (position == 4) {
            return new MonumentFiveFragment();
        } else {
            return new MonumentSixFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

      @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}