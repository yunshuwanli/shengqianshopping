package yswl.priv.com.shengqianshopping.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import yswl.com.klibrary.base.MFragment;
import yswl.priv.com.shengqianshopping.bean.CategoryBean;

/**
 * Created by nixn@yunhetong.net on 2015/11/4.
 */
public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {
    //    private final String TAG="CommonFragmentPagerAdapter";
    private List<MFragment> fragmentList;
    private List<CategoryBean> titles;

    public CommonFragmentPagerAdapter(FragmentManager fm, List<MFragment> fragmentList, List<CategoryBean> titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int arg0) {
//        Lx.d(TAG,"getItem "+arg0);
        if (arg0 < fragmentList.size() && arg0 >= 0) {
            return fragmentList.get(arg0);
        } else {
            return null;
        }

    }


    @Override
    public CharSequence getPageTitle(int position) {
        CategoryBean categoryBean = titles.get(position);
        if (categoryBean != null)
            return categoryBean.title;
        return " ";
    }

    @Override
    public int getCount() {
        int count = fragmentList != null ? fragmentList.size() : 0;
//        Lx.d(TAG,"count" +count+"  this "+this +"  fragment  "+fragmentList.getInstance(0));
        return count;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}
