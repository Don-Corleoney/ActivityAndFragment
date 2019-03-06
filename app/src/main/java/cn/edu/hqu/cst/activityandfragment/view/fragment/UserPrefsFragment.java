package cn.edu.hqu.cst.activityandfragment.view.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.edu.hqu.cst.activityandfragment.R;

public class UserPrefsFragment extends PreferenceFragment {
    private EditTextPreference userEditTextPreference=null;
    private ListPreference genderListPreference=null;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //载入布局资源文件
        addPreferencesFromResource(R.xml.user_perfs);
        //获取传入的参数
        String webstie=getArguments().getString("website");
        Toast.makeText(getActivity(),"传入的webiste参数为："+webstie,Toast.LENGTH_SHORT).show();
        //获取设置控件
        userEditTextPreference=(EditTextPreference)findPreference("name");
        genderListPreference=(ListPreference)findPreference("gender");
        //设置初始显示界面用户名
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this.getActivity());
        String userName=sharedPreferences.getString("name","username");
        userEditTextPreference.setSummary(userName);
        //设置初始显示界面性别
        String gender=getResources().getStringArray(R.array.gender_name_list)[Integer.parseInt(sharedPreferences.getString("gender","0"))];
        genderListPreference.setSummary(gender);


        //改变用户名后设置框显示设置后的用户名
        userEditTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {

                preference.setSummary(newValue.toString());
                return true;
            }
        });
        //改变性别后，设置框显示改变后的值
        genderListPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                preference.setSummary(getResources().getStringArray(R.array.gender_name_list)[Integer.parseInt(newValue.toString())]);
                return true;
            }
        });
    }
}
