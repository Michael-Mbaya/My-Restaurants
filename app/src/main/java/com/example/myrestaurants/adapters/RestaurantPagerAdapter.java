package com.example.myrestaurants.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myrestaurants.models.Business;
import com.example.myrestaurants.ui.RestaurantDetailFragment;

import java.util.List;


public class RestaurantPagerAdapter extends FragmentPagerAdapter {
    private List<Business> mRestaurants;

    //RestaurantPagerAdapter() is a constructor
    // where we set the required FragmentManager and
    // array list of restaurants we will be swiping through.
    public RestaurantPagerAdapter(FragmentManager fm, int behavior, List<Business> restaurants) {
        super(fm, behavior);
        mRestaurants = restaurants;
    }

    //This method, getItem(), returns an instance
    // of the RestaurantDetailFragment for the restaurant
    // in the position provided as an argument.
    @Override
    public Fragment getItem(int position) {
        return RestaurantDetailFragment.newInstance(mRestaurants.get(position));
    }

    //getCount() simply determines how many restaurants are in our Array List.
    // This lets our adapter know how many fragments it must create.
    @Override
    public int getCount() {
        return mRestaurants.size();
    }

    //getPageTitle() updates the title that appears in the scrolling tabs
    // at the top of the screen.
    @Override
    public CharSequence getPageTitle(int position) {
        return mRestaurants.get(position).getName();
    }
}

