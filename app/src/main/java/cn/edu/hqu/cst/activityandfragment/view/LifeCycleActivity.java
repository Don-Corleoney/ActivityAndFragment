package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import cn.edu.hqu.cst.activityandfragment.R;

public class LifeCycleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d("生命周期回调：","onCreate");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("生命周期回调：","onRestoreInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("生命周期回调：","onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("生命周期回调：","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("生命周期回调：","onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("生命周期回调：","onSaveInstanceState");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("生命周期回调：","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("生命周期回调：","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("生命周期回调：","onDestroy");
    }
}
