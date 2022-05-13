package com.elseplus.opencv4android2arr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Log.e(TAG,"JNI REST:"+stringFromJNI());
        Log.e(TAG,"JNI REST:"+getSignKeyFromJNI("abc"));

        boolean success = OpenCVLoader.initDebug();
        if (!success) {
            Log.e("TAG", "初始化失败");
            tv.setText("opencv 初始化失败 !!!");
            tv.setTextColor(Color.RED);
        }else {
            tv.setText("opencv 初始化成功 !!! ver."+OpenCVLoader.OPENCV_VERSION +",jnicall:"+ stringFromJNI());
            Log.e("TAG", "opencv 初始化成功 !! ver."+OpenCVLoader.OPENCV_VERSION);
            tv.setTextColor(Color.BLUE);
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String getSignKeyFromJNI(String origin);
}