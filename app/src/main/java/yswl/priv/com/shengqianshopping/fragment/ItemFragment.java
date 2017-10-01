package yswl.priv.com.shengqianshopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import yswl.com.klibrary.base.MFragment;
import yswl.com.klibrary.http.CallBack.HttpCallback;
import yswl.priv.com.shengqianshopping.R;
import yswl.priv.com.shengqianshopping.banner.SortEnum;
import yswl.priv.com.shengqianshopping.bean.CategoryBean;


public class ItemFragment extends MFragment implements View.OnClickListener, HttpCallback<JSONObject> {

    private static final int REQUEST_ID = 1003;

    private static final String ARG_PARAM1 = "param1";

    private CategoryBean mParam1;


    public ItemFragment() {
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
    public static ItemFragment newInstance(CategoryBean param1) {
        ItemFragment fragment = new ItemFragment();
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
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

    GridRecyclerviewFragment mFragment;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        TextView hotProduct = (TextView) view.findViewById(R.id.tv_hot);
        TextView newProduct = (TextView) view.findViewById(R.id.tv_new);

        TextView sellCountProduct = (TextView) view.findViewById(R.id.tv_sell_count);
        TextView priceProduct = (TextView) view.findViewById(R.id.tv_price);

        hotProduct.setOnClickListener(this);
        newProduct.setOnClickListener(this);
        sellCountProduct.setOnClickListener(this);
        priceProduct.setOnClickListener(this);

        mFragment = GridRecyclerviewFragment.newInstance(mParam1);
        getFragmentManager().beginTransaction()
                .replace(R.id.content, mFragment)
                .commitAllowingStateLoss();
    }


    @Override
    public void onClick(View v) {
        if (mFragment != null && mFragment.isAdded() && mFragment.isVisible()) {
            int id = v.getId();
            switch (id) {
                case R.id.tv_hot:
                    mFragment.requestPinkageData(SortEnum.HOT);
                    break;
                case R.id.tv_new:
                    mFragment.requestPinkageData(SortEnum.NEW);
                    break;
                case R.id.tv_sell_count:
                    mFragment.requestPinkageData(SortEnum.VOLUME);
                    break;
                case R.id.tv_price:
                    mFragment.requestPinkageData(SortEnum.PRICE);
                    break;
            }
        }
    }


    @Override
    public void onSucceed(int requestId, JSONObject result) {

    }

    @Override
    public void onFail(int requestId, String errorMsg) {

    }
}
