package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;   //The OnClickListener is one of many interfaces (https://developer.android.com/reference/android/view/View.html#nestedclasses) included in Android's View class.
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import butterknife.Bind;  //depreciated
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
//    private Button mFindRestaurantsButton;
//    private EditText mLocationEditText;
//    private TextView mAppNameTextView;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                  //pass data with intent extras
                  intent.putExtra("location", location);
                  //go to restaurant activity
                  startActivity(intent);

            }

    }
}