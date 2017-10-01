package yswl.priv.com.shengqianshopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import yswl.com.klibrary.base.MFragment;
import yswl.com.klibrary.http.CallBack.HttpCallback;
import yswl.com.klibrary.http.HttpClientProxy;
import yswl.com.klibrary.util.L;
import yswl.priv.com.shengqianshopping.R;
import yswl.priv.com.shengqianshopping.banner.SortEnum;
import yswl.priv.com.shengqianshopping.bean.CategoryBean;
import yswl.priv.com.shengqianshopping.fragment.adapter.DividerItemDecoration;
import yswl.priv.com.shengqianshopping.fragment.adapter.GridRecyclerFragmentAdapter;
import yswl.priv.com.shengqianshopping.util.UrlUtil;

/**
 *
 */
public class GridRecyclerviewFragment extends MFragment implements HttpCallback<JSONObject> {
    RecyclerView mRecyclerView;
    GridRecyclerFragmentAdapter mAdaoter;


    private static final int REQUEST_ID = 1003;

    private static final String ARG_PARAM1 = "param1";

    private CategoryBean mParam1;


    public GridRecyclerviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GridRecyclerviewFragment newInstance(CategoryBean param1) {
        GridRecyclerviewFragment fragment = new GridRecyclerviewFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (CategoryBean) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grid_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);

        manager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        mAdaoter = new GridRecyclerFragmentAdapter();

        requestPinkageData(null);

    }

    /**
     * 1. pid | 不可 | 选品库ID |
     * 1. lastId | 可 | | 默认0 | 由于volume有0值，销量默认－1
     * 1. count | 可 | | 默认20
     * 1. sort | 可 | 排序字段 | popularity/人气-默认 , volume/售量 ， new/最新 , price/价格
     * 1. sortBy | 可 | 排序方式 | 正序:asc 倒序:desc-默认
     */
    public void requestPinkageData(SortEnum sort) {
        if (mParam1 == null) return;
        String url = UrlUtil.getUrl(this, R.string.url_category_list);
        Map<String, Object> par = new HashMap<>();
        par.put("pid", mParam1.pid);
        if (sort != null)
            par.put("sort", sort.getValue());
        HttpClientProxy.getInstance().postAsyn(url, REQUEST_ID, par, this);
    }


    private static final String TAG = GridRecyclerviewFragment.class.getSimpleName();

    @Override
    public void onSucceed(int requestId, JSONObject result) {
        L.e(TAG, "onSucceed result :" + result);

    }

    @Override
    public void onFail(int requestId, String errorMsg) {

    }
}
