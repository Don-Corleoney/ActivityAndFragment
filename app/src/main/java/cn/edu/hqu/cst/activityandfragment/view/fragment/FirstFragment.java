package cn.edu.hqu.cst.activityandfragment.view.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import cn.edu.hqu.cst.activityandfragment.R;

public class FirstFragment extends ListFragment {
    private ListView listView=null;
    public String[] itemList={"信息安全","计算机科学与技术","网络工程"};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,itemList);
        setListAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_first,container,false);
        return view;
    }

}

