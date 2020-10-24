package com.example.myrestaurants.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myrestaurants.Constants;
import com.example.myrestaurants.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

//import butterknife.Bind;  //depreciated

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();

//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;
    private DatabaseReference mSearchedLocationReference;

    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //firebase db
        mSearchedLocationReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);
        //
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "font/fallingsky.otf");
//        mAppNameTextView.setTypeface(ostrichFont);

        //shared preference
//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();
        //create Click Listener for our button
        mFindRestaurantsButton.setOnClickListener(this);    //note this

    }

            @Override   //onClick now not nested in OnCreate
            public void onClick(View v) {
  //Now, as we add more links and buttons we can simply call
  // .setOnClickListener() on the Viewelement we'd like to attach a click listener to,
  // and add another if statement to the onClick()method. Awesome!
              if(v==mFindRestaurantsButton){
                //gathering data from editText
                String location = mLocationEditText.getText().toString();

                  saveLocationToFirebase(location);
//                addToSharedPreferences(location);
//                  if(!(location).equals("")) {
//                      addToSharedPreferences(location);
//                  }
                  Intent intent = new Intent(MainActivity.this, RestaurantsListActivity.class);
                  //pass data with intent extras
                  intent.putExtra("location", location);
                  //go to restaurant activity
                  startActivity(intent);

            }

    }

    public void saveLocationToFirebase(String location) {
        mSearchedLocationReference.push().setValue(location);
    }

//    private void addToSharedPreferences(String location) {
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }

}