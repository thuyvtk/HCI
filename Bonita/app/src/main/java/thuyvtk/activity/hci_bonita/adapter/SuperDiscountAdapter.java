package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class SuperDiscountAdapter extends RecyclerView.Adapter<SuperDiscountAdapter.MyView> {

    public Integer[] images = {
      R.drawable.discount1,
      R.drawable.discount2,
      R.drawable.discount3,
      R.drawable.discount4,
    };

    public String[] discountNumbers = {
      "-69%",
      "-80%",
      "Miễn phí 1 dịch vụ",
      "-50%",
    };

    public String[] names = {
            "HAIR STAR",
            "NHAT THIEN SALON",
            "Loli Nail",
            "Bac Tran Tien Hair"
    };


    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.super_discount_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImage.setImageResource(images[position]);
        holder.txtDiscout.setText(discountNumbers[position]);
        holder.txtName.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
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
