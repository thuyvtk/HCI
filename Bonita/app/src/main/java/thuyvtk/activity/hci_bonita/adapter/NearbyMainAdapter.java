package thuyvtk.activity.hci_bonita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.activity.DetailDiscountActivity;

public class NearbyMainAdapter extends RecyclerView.Adapter<NearbyMainAdapter.MyView>{
    private Integer[] imgs;
    private Context context;
    private String[] discounts = {
            "-50%",
            "-69k",
            "Free 1",
            "300k",
            "-49%",
            "-25%",
            "-50%",
    };
    public String[] name = {
            "HANA MAKEUP : Trang điểm cô dâu",
            "30 SHINE : Toàn dịch vụ",
            "YORO JOLIES : Toàn dịch vụ",
            "CHANG NAILS : Toàn dịch vụ",

            "JOSI SALON : Làm tóc cô dâu",
            "LONG HAIR : Toàn dịch vụ",
            "YORO JOLIES : Makeup cô dâu",
    };
    private String[] spaces= {
      "1.7 km", "1.9 km", "2.3 km", "2.5 km", "2.7 km", "3 km", "3.5km",
    };

    public NearbyMainAdapter(Integer[] imgs, Context context) {
        this.imgs = imgs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_main, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImg1.setImageResource(imgs[position]);
        holder.txtName.setText(name[position]);
        holder.txtDiscount.setText(discounts[position]);
        holder.txtSpace.setText(spaces[position]);
        holder.ivImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailDiscountActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivImg1;
        public TextView txtDiscount;
        public TextView txtName;
        public TextView txtSpace;


        public MyView(View view) {
            super(view);
            ivImg1 = view.findViewById(R.id.ivImg1);
            txtDiscount = view.findViewById(R.id.txtDiscount);
            txtName = view.findViewById(R.id.txtName);
            txtSpace = view.findViewById(R.id.txtSpace);

        }
    }
}
