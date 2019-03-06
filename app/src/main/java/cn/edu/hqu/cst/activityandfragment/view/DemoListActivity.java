package cn.edu.hqu.cst.activityandfragment.view;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

import cn.edu.hqu.cst.activityandfragment.R;

public class DemoListActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] itemList={"信息安全","计算机科学与技术","网络工程"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,itemList);
        ListView listView=this.getListView();
        //
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        //列表栏被点击，可以在此处完成不同的工作
        SparseBooleanArray checkItems=l.getCheckedItemPositions();
        Log.i("打印选中项开始","-------------------------------------------------------------");
        String checkedItemStr="";
        for (int i = 0; i < checkItems.size(); ++i){
            if(checkItems.valueAt(i)==true){//表示第i个元素被选中
                checkedItemStr=checkedItemStr+i+",";
            }
        }
        Log.i("当前选中项为",checkedItemStr);
        Log.i("打印选中项结束","-------------------------------------------------------------");
        Toast.makeText(this,"点击了，第"+position+"个列表栏，带列表栏对应的数据为第"+id+"个",Toast.LENGTH_SHORT).show();

    }
}
