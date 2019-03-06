package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import cn.edu.hqu.cst.activityandfragment.R;

public class IntentActivity extends Activity implements View.OnClickListener {

    Button btn_open_dial,btn_open_web,btn_set_wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        btn_open_dial=findViewById(R.id.btn_open_dial);
        btn_open_web=findViewById(R.id.btn_open_web);
        btn_set_wifi=findViewById(R.id.btn_set_wifi);
        btn_open_dial.setOnClickListener(this);
        btn_open_web.setOnClickListener(this);
        btn_set_wifi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("调试输出","xx");
        Intent intent=new Intent();
        switch (v.getId()) {
            case R.id.btn_open_dial:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1320010001"));
                startActivity(intent);
                break;
            case R.id.btn_open_web:
                intent.setAction(Intent.ACTION_VIEW);//为Intent设置Action属性
                intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
                startActivity(intent);
                break;
            case R.id.btn_set_wifi:
                intent.setAction("android.settings.WIFI_SETTINGS");
                startActivity(intent);
                break;
        }

    }
}
