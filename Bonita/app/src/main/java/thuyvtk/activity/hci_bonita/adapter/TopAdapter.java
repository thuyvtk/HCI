package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.MyView> {

    public Integer[] tops = {
            R.drawable.top2,
            R.drawable.top1,
            R.drawable.top3,
            R.drawable.top4,
            R.drawable.top5,
            R.drawable.top8,
            R.drawable.top7,
            R.drawable.top6,
            R.drawable.top6,
            R.drawable.top4,
            R.drawable.top8,
            R.drawable.top3,
    };

    public String[] discounts = {
            "-50%",
            "-69k",
            "Free 1",
            "300k",
            "-49%",
            "-25%",
            "-50%",
            "-69k",
            "300k",
            "Free 1",
            "-25%",
            "-30%",

    };

    public String[] topNumber = {
            "1","4","7","10","2","5","8","11","3","6","9","12"
    };

    public String[] name = {
            "HANA MAKEUP : Trang điểm cô dâu",
            "30 SHINE : Toàn dịch vụ",
            "YORO JOLIES : Toàn dịch vụ",
            "CHANG NAILS : Toàn dịch vụ",

            "JOSI SALON : Làm tóc cô dâu",
            "LONG HAIR : Toàn dịch vụ",
            "YORO JOLIES : Makeup cô dâu",
            "CHANG HAIR : Cắt tóc",

            "MINH CHIEN HAIR : Đồng giá làm tóc",
            "LOLI NAILS : Miễn phí 1 dịch vụ",
            "Nhat Thien Salon : Toàn dịch vụ",
            "CHANG Salon : Trang điểm cô dâu",

    };
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImg1.setImageResource(tops[position]);
        holder.ivImg2.setImageResource(tops[position + 4]);
        holder.ivImg3.setImageResource(tops[position + 8]);

        holder.txtTop.setText(topNumber[position]);
        holder.txtTop2.setText(topNumber[position+4]);
        holder.txtTop3.setText(topNumber[position+8]);

        holder.txtDiscount.setText(discounts[position]);
        holder.txtDiscount2.setText(discounts[position + 4]);
        holder.txtDiscount3.setText(discounts[position + 8]);

        holder.txtName.setText(name[position]);
        holder.txtName2.setText(name[position + 4]);
        holder.txtName3.setText(name[position + 8]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivImg1;
        public TextView txtTop;
        public TextView txtDiscount;
        public TextView txtName;
        public TextView txtNumberOder;

        public ImageView ivImg2;
        public TextView txtTop2;
        public TextView txtDiscount2;
        public TextView txtName2;
        public TextView txtNumberOder2;

        public ImageView ivImg3;
        public TextView txtTop3;
        public TextView txtDiscount3;
        public TextView txtName3;
        public TextView txtNumberOder3;


        public MyView(View view) {
            super(view);
            ivImg1 = view.findViewById(R.id.ivImg1);
            txtTop = view.findViewById(R.id.txtTop);
            txtDiscount = view.findViewById(R.id.txtDiscount);
            txtName = view.findViewById(R.id.txtName);
            txtNumberOder = view.findViewById(R.id.txtNumberOder);

            ivImg2 = view.findViewById(R.id.ivImg2);
            txtTop2 = view.findViewById(R.id.txtTop2);
            txtDiscount2 = view.findViewById(R.id.txtDiscount2);
            txtName2 = view.findViewById(R.id.txtName2);
            txtNumberOder2 = view.findViewById(R.id.txtNumberOder2);

            ivImg3 = view.findViewById(R.id.ivImg3);
            txtTop3 = view.findViewById(R.id.txtTop3);
            txtDiscount3 = view.findViewById(R.id.txtDiscount3);
            txtName3 = view.findViewById(R.id.txtName3);
            txtNumberOder3 = view.findViewById(R.id.txtNumberOder3);


        }
    }
}
