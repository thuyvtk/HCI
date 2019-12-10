package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class BrandChildAdapter extends RecyclerView.Adapter<BrandChildAdapter.MyView>{

    private Integer[] images;
    private String[] brandNames;

    public String[] discounts = {
            "4 khuyến mãi",
            "3 khuyến mãi",
            "4 khuyến mãi",
            "3 khuyến mãi",
            "5 khuyến mãi",
            "2 khuyến mãi",
    };

    public String[] rates = {
            "4.5 ",
            "4.7 ",
            "4.3 ",
            "4.8 ",
            "4.4 ",
            "4.1 "
    };

    public BrandChildAdapter(Integer[] images, String[] brandNames) {
        this.images = images;
        this.brandNames = brandNames;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_child_layout, parent, false);
        return new BrandChildAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivBrand.setImageResource(images[position]);
        holder.txtBrandName.setText(brandNames[position]);
        holder.txtTotalDiscount.setText(discounts[position]);
        holder.txtRate.setText(rates[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivBrand;
        public TextView txtBrandName;
        public TextView txtRate;
        public TextView txtTotalDiscount;


        public MyView(View view) {
            super(view);
            ivBrand = view.findViewById(R.id.ivBrand);
            txtBrandName = view.findViewById(R.id.txtBrandName);
            txtRate = view.findViewById(R.id.txtRate);
            txtRate = view.findViewById(R.id.txtRate);
            txtTotalDiscount = view.findViewById(R.id.txtTotalDiscount);
        }
    }
}
