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

public class NearbyChildAdapter extends RecyclerView.Adapter<NearbyChildAdapter.MyView> {
    private Context context;
    private Integer[] images;
    private String[] discountNumbers;
    private String[] names;
    public String[] spaces = {
      "247 lượt đặt - 1.8km",
      "100 lượt đặt - 2.0km",
      "95 lượt đặt - 2.3km",
    };

    public NearbyChildAdapter(Context context, Integer[] images, String[] discountNumbers, String[] names) {
        this.context = context;
        this.images = images;
        this.discountNumbers = discountNumbers;
        this.names = names;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_child_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImage.setImageResource(images[position]);
        holder.txtDiscout.setText(discountNumbers[position]);
        holder.txtName.setText(names[position]);
        holder.txtSpace.setText(spaces[position]);
        holder.ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailDiscountActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivImage;
        public TextView txtDiscout;
        public TextView txtName;
        public TextView txtSpace;

        public MyView(View view) {
            super(view);
            ivImage = view.findViewById(R.id.ivImage);
            txtDiscout = view.findViewById(R.id.txtDiscount);
            txtName = view.findViewById(R.id.txtName);
            txtSpace = view.findViewById(R.id.txtSpace);
        }
    }
}
