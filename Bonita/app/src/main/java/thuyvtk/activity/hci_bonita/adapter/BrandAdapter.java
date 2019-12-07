package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.MyView> {

    public Integer[] images = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
    };

    public String[] brandNames = {
      "Chang Nails",
      "30 Shine",
      "Loli Nails",
      "Gift Salon",
      "Men Barber",
      "Farther Cut"
    };

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

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_layout, parent, false);
        return new BrandAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivBrand.setImageResource(images[position]);
        holder.txtBrandName.setText(brandNames[position]);
        holder.txtTotalDiscount.setText(discounts[position]);
        holder.txtRate.setText(rates[position]);
//
        holder.ivBrandNext.setImageResource(images[position+3]);
        holder.txtBrandNameNext.setText(brandNames[position + 3]);
        holder.txtRateNext.setText(rates[position+3]);
        holder.txtTotalDiscountNext.setText(discounts[position+3]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivBrand;
        public TextView txtBrandName;
        public TextView txtRate;
        public TextView txtTotalDiscount;

        public ImageView ivBrandNext;
        public TextView txtBrandNameNext;
        public TextView txtRateNext;
        public TextView txtTotalDiscountNext;


        public MyView(View view) {
            super(view);
            ivBrand = view.findViewById(R.id.ivBrand);
            txtBrandName = view.findViewById(R.id.txtBrandName);
            txtRate = view.findViewById(R.id.txtRate);
            txtRate = view.findViewById(R.id.txtRate);
            txtTotalDiscount = view.findViewById(R.id.txtTotalDiscount);

            ivBrandNext = view.findViewById(R.id.ivBrandNext);
            txtBrandNameNext = view.findViewById(R.id.txtBrandNameNext);
            txtRateNext = view.findViewById(R.id.txtRateNext);
            txtTotalDiscountNext = view.findViewById(R.id.txtTotalDiscountNext);
        }
    }
}
