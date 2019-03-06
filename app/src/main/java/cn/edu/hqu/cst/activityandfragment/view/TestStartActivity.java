package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Test;

import cn.edu.hqu.cst.activityandfragment.R;

public class TestStartActivity extends Activity {

    private final  int REQUEST_CODE=0;
    private Button btnTestStartActivityWithResult=null;
    private Button btnTestStartActivityWithoutResult=null;
    private TextView tvResult=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start);
        btnTestStartActivityWithResult=findViewById(R.id.startActivityWithResult);
        btnTestStartActivityWithoutResult=findViewById(R.id.startActivityWithNoResult);
        btnTestStartActivityWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestStartActivity.this,WithResultActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                tvResult=findViewById(R.id.txResult);
            }
        });
        btnTestStartActivityWithoutResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestStartActivity.this,NoResultActivity.class);
                intent.putExtra("param","这是从第一个Activity传递过来的参数");
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==1){
            String result=data.getExtras().getString("inputStr");
            tvResult.setText(result);
        }
    }
}
