package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import cn.edu.hqu.cst.activityandfragment.R;
import cn.edu.hqu.cst.activityandfragment.view.fragment.FirstFragment;
import cn.edu.hqu.cst.activityandfragment.view.fragment.SecondFragment;

public class TestFragmentActivity extends Activity {
    FirstFragment firstFragment=null;
    SecondFragment secondFragment=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        firstFragment=(FirstFragment)getFragmentManager().findFragmentById(R.id.firstFragment);
        secondFragment=(SecondFragment)getFragmentManager().findFragmentById(R.id.secondFragment);
        final TextView textView=findViewById(R.id.show_intro);
        textView.setText(getString(R.string.about_intro));
        ListView listView=firstFragment.getListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                textView.setText("当前为:"+firstFragment.itemList[(int)id]+"专业的介绍");
            }
        });

    }
}
