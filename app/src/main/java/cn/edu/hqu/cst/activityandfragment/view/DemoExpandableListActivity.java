package cn.edu.hqu.cst.activityandfragment.view;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.ExpandedMenuView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.hqu.cst.activityandfragment.R;

public class DemoExpandableListActivity extends ExpandableListActivity {

    //准备数据
    //第一层显示的图标
    private int[] logos=new int[]{
            R.drawable.icon_cst,
            R.drawable.icon_law,
            R.drawable.icon_chemistry
    };
    //第一层显示的数据
    private String[] colleges=new String[]{
            "计算机学院",
            "法学院",
            "化学院"
    };
    //第二层显示的数据，为二维数组，可以展开
    private String[][] Major=new String[][]{
            {"软件工程","网络工程","信息安全","计算机科学与技术"},
            {"法理学","政治学与行政学"},
            {"化学工程与工艺专业","生物工程专业"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {


            //一共有多少组
            @Override
            public int getGroupCount() {
                return colleges.length;
            }

            //第groupPosition组的项目数
            @Override
            public int getChildrenCount(int groupPosition) {
                return Major[groupPosition].length;
            }

            //返回第groupPosition组
            @Override
            public Object getGroup(int groupPosition) {

                return colleges[groupPosition];
            }

            //返回第groupPosion，第childPosition个项目
            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return Major[groupPosition][childPosition];
            }

            //返回第groupPosition的编号
            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            //返回第groupPosition组，第childPosition个编号
            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            //编号是否稳定
            @Override
            public boolean hasStableIds() {
                return true;
            }

            //返回第groupPositon组项目视图，组项目前面放置图标，后面为文字，因此是水平线性布局
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                //组装显示学院的layout
                LinearLayout itemLayout=new LinearLayout(DemoExpandableListActivity.this);
                itemLayout.setOrientation(LinearLayout.HORIZONTAL);
                //先添加图标
                ImageView logo=new ImageView(DemoExpandableListActivity.this);
                logo.setImageResource(logos[groupPosition]);
                itemLayout.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(groupPosition).toString());
                //再添加文本
                itemLayout.addView(textView);
                return itemLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                //子项目仅有一个文本
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }
            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        setListAdapter(adapter);
        //获取ExpandableListActivity里的ExpandableListView控件
        ExpandableListView expandableListView=this.getExpandableListView();
        //设置点击Group时的监听器
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(DemoExpandableListActivity.this,"点击了第"+groupPosition+"组",Toast.LENGTH_SHORT).show();
                Log.i("点击了：",colleges[(int)id]);
                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(DemoExpandableListActivity.this,"点击了第"+groupPosition+"组的第"+childPosition+"项",Toast.LENGTH_SHORT).show();
                Log.i("点击了：",Major[groupPosition][(int)id]);
                return false;
            }
        });
    }

    //创建一个TextView
    @NonNull
    private TextView getTextView() {
        TextView textView=new TextView(DemoExpandableListActivity.this);
        textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64));
        textView.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.LEFT);
        textView.setPadding(36,0,0,0);
        textView.setTextSize(20);
        return textView;
    }

}
