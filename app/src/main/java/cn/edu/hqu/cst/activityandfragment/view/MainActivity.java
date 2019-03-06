package cn.edu.hqu.cst.activityandfragment.view;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.edu.hqu.cst.activityandfragment.R;

public class MainActivity extends LauncherActivity {
    //定义启动界面的列表项目名称
    private String[] demoMenuList={"ListActivity","ExpandableListActivity","PreferenceActivity","生命周期回调测试","启动Activity测试","Fragment测试","Intent测试"};
    //启动的目标Activity，演示多个Activity使用情况
    private Class<?>[] demoMenuObject={DemoListActivity.class,DemoExpandableListActivity.class,DemoPreferenceActivity.class,LifeCycleActivity.class,TestStartActivity.class,TestFragmentActivity.class,IntentActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ArrayAdapter需要提供上下文，item布局和字符串数组
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,demoMenuList);
        //设置适配器
        setListAdapter(adapter);
    }

    @Override
    protected Intent intentForPosition(int position) {
        //点击项目时的回调，position为点击的项目索引，通过该索引跳转到不同Activity
        return new Intent(MainActivity.this,demoMenuObject[position]);
    }
}
