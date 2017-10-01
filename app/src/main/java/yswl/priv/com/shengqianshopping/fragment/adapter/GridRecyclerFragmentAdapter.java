package yswl.priv.com.shengqianshopping.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import yswl.priv.com.shengqianshopping.R;

/**
 * Created by yunshuwanli on 17/10/1.
 */

public class GridRecyclerFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public GridRecyclerFragmentAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).
                inflate(R.layout.pinkage_recyclerview_item_view,parent,false);
        return new GridRecyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class GridRecyHolder extends RecyclerView.ViewHolder{
        ImageView preview_img;
        TextView coup_price;
        TextView product_desc;
        TextView product_price;
        TextView produce_buy_count;
        public GridRecyHolder(View view){
            super(view);
            preview_img = (ImageView) view.findViewById(R.id.iv_product_preview);
            coup_price = (TextView) view.findViewById(R.id.tv_coup_price);
            product_desc = (TextView) view.findViewById(R.id.tv_product_desc);
            product_price = (TextView) view.findViewById(R.id.tv_product_price);
            produce_buy_count = (TextView) view.findViewById(R.id.tv_number_people);

        }
    }
}
