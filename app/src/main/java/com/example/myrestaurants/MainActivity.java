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
            //find by id in layout (refactored by Butterknife)
//        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
//        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantsButton);
//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
            ButterKnife.bind(this);

        //create Click Listener for our button
        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //let’s add a toast. A toast is a simple pop up message that automatically fades in and out of the screen when triggered.
//                Toast.makeText(MainActivity.this, "Hello World!", Toast.LENGTH_LONG).show();
                //create an Intent to take to another Layout
                //An intent represents something our app “intends to do” by describing a simple action you'd like the app to perform.
                // Most often, an intent is used to start another activity or to hand something over to another app.

                //gathering data from editText
                String location = mLocationEditText.getText().toString();
//                Log.d(TAG, location);
                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
                    //pass data with intent extras
                intent.putExtra("location",location);
                    //go to restaurant activity
                startActivity(intent);


                    //to have visual confirm of line 39-43
//                Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
////                startActivity(intent);
//                String location = mLocationEditText.getText().toString();
//                Toast.makeText(MainActivity.this, location, Toast.LENGTH_LONG).show();
            }
        });

    }
}