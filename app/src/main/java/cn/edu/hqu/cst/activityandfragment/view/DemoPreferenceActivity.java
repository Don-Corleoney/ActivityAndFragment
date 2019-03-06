package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Button;

import java.util.List;

import cn.edu.hqu.cst.activityandfragment.R;

public class DemoPreferenceActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //添加设置
        if(hasHeaders()){
            Button button=new Button(this);
            button.setText(getText(R.string.setting_op));
            //底部增加一个按钮
            setListFooter(button);
        }
    }
    
    @Override
    public void onBuildHeaders(List<Header> target) {
        //加载设置列表项
        loadHeadersFromResource(R.xml.preference_headers,target);
    }

    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }
}
