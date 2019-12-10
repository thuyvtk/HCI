package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.MyView> {

    public Integer[] images = {
            R.drawable.deadline1,
            R.drawable.deadline2,
            R.drawable.deadline3,
            R.drawable.deadline4,
    };

    public String[] discounts = {
            "-25%", "-50%", "300K", "269K"
    };

    public String[] names = {
            "KEIRIN HAIR : Toàn dịch vụ",
            "LIFE SALON : Làm tóc cô dâu",
            "NHAT THIEN SALON : Làm tóc",
            "BAC TRAN TIEN HAIR : Đồng giá nhuộm"
    };

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_layout, parent, false);
        return new AllAdapter.MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImage.setImageResource(images[position]);
        holder.txtDiscout.setText(discounts[position]);
        holder.txtName.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivImage;
        public TextView txtDiscout;
        public TextView txtName;

        public MyView(View view) {
            super(view);
            ivImage = view.findViewById(R.id.ivImage);
            txtDiscout = view.findViewById(R.id.txtDiscount);
            txtName = view.findViewById(R.id.txtName);
        }
    }
}
