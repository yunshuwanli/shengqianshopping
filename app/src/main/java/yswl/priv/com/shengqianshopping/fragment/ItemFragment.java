package yswl.priv.com.shengqianshopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import yswl.com.klibrary.base.MFragment;
import yswl.priv.com.shengqianshopping.R;


public class ItemFragment extends MFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);
    }

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
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tv_hot:

                break;
            case R.id.tv_new:

                break;
            case R.id.tv_sell_count:

                break;
            case R.id.tv_price:
                break;
        }
    }


}
