package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import junit.framework.Test;

import cn.edu.hqu.cst.activityandfragment.R;

public class WithResultActivity extends Activity {

    private final int RESULT_CODE=1;
    private Button btnWithResult=null;
    private EditText eTInput=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_result);
        btnWithResult=findViewById(R.id.btnWithResult);
        eTInput=findViewById(R.id.eTInput);
        btnWithResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr=eTInput.getText().toString();
                Intent intent=new Intent(WithResultActivity.this, TestStartActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("inputStr",inputStr);
                intent.putExtras(bundle);
                setResult(RESULT_CODE,intent);
                finish();



            }
        });
    }
}
