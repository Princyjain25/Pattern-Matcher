package com.example.pattern_matcher;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.provider.MediaStore;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.media.MediaPlayer;
import com.example.pattern_matcher.MainActivity;
import java.util.ArrayList;
public class second extends Activity implements GestureOverlayView.OnGesturePerformedListener {
    GestureLibrary mLibrary;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mLibrary = GestureLibraries.fromRawResource(this, R.raw.gesture);
        if (!mLibrary.load()) {
            finish();
        }
        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.addOnGesturePerformedListener(this);
    }


public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        ArrayList<Prediction> predictions = mLibrary.recognize(gesture);

        if (predictions.size() > 0 && predictions.get(0).score > 1.0) {
        String result = predictions.get(0).name;

        if ("w".equalsIgnoreCase(result))
        {
        Toast.makeText(this, "Opening whatsapp", Toast.LENGTH_LONG).show();
        Intent launchIntent =
        getPackageManager().getLaunchIntentForPackage("com.whatsapp");
        if (launchIntent != null) {
        startActivity(launchIntent);
        }
        }
        else if ("o".equalsIgnoreCase(result)) {
        Toast.makeText(this, "Opening camera", Toast.LENGTH_LONG).show();
        Intent launchIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (launchIntent != null) {
        startActivity(launchIntent);
        }
        }
        else if ("s".equalsIgnoreCase(result)) {
        Toast.makeText(this, "Opening settings", Toast.LENGTH_LONG).show();
        Intent launchIntent =
        getPackageManager().getLaunchIntentForPackage("com.android.settings");
        if (launchIntent != null) {
        startActivity(launchIntent);
        }
        }
        else if ("g".equalsIgnoreCase(result)) {
        Toast.makeText(this, "Opening gaana", Toast.LENGTH_LONG).show();
        Intent launchIntent =
        getPackageManager().getLaunchIntentForPackage("com.gaana");
        if (launchIntent != null) {
        startActivity(launchIntent);
        }
        }
        else if ("c".equalsIgnoreCase(result)) {
            Toast.makeText(this, "Opening google chrome", Toast.LENGTH_LONG).show();
            Intent launchIntent =
                    getPackageManager().getLaunchIntentForPackage("com.android.chrome");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }

        else if ("m".equalsIgnoreCase(result)) {
            Toast.makeText(this, "Opening myntra", Toast.LENGTH_LONG).show();
            Intent launchIntent =
                    getPackageManager().getLaunchIntentForPackage("com.myntra.android");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }

        else if ("p".equalsIgnoreCase(result)) {
            Toast.makeText(this, "Opening jio tv", Toast.LENGTH_LONG).show();
            Intent launchIntent =
                    getPackageManager().getLaunchIntentForPackage("com.jio.jioplay.tv");
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
        }


        }
        }
        }