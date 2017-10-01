package yswl.priv.com.shengqianshopping.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import yswl.com.klibrary.base.MFragment;
import yswl.priv.com.shengqianshopping.R;
import yswl.priv.com.shengqianshopping.bean.CategoryBean;

public class DataGenerator {

    public static final int[] mTabRes = new int[]{R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round};
    public static final int[] mTabResPressed = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    public static final String[] mTabTitle = new String[]{"首页", "借款", "认证", "我的"};

    public static MFragment[] getFragments() {
        MFragment fragments[] = new MFragment[4];
        fragments[0] = new HomeFragment2();
        fragments[2] = new RebateFragment();
        fragments[1] = new PinkageFragment();
        fragments[3] = new UserInfoFragment2();
        return fragments;
    }
    public static List<MFragment> getFragments2(List<CategoryBean> categorys) {
        List<MFragment> fragments = new ArrayList<>();
        for (CategoryBean categroybean:categorys) {
            fragments.add(ItemFragment.newInstance(categroybean));
        }

        return fragments;
    }





}