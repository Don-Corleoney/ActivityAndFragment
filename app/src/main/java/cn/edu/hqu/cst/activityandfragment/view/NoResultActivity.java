package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Test;

import cn.edu.hqu.cst.activityandfragment.R;

public class NoResultActivity extends Activity {

    Button btnReturnWithoutFinish=null;
    Button btnReturnWithFinish=null;
    TextView tvParam=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_result);
        btnReturnWithFinish=findViewById(R.id.returnWithFinish);
        btnReturnWithoutFinish=findViewById(R.id.returnWithOutFinish);
        tvParam=findViewById(R.id.tvShowResult);
        tvParam.setText(getIntent().getStringExtra("param"));
        btnReturnWithFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoResultActivity.this,TestStartActivity.class);
                startActivity(intent);
            }
        });
        btnReturnWithoutFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoResultActivity.this,TestStartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
