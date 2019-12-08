package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class DeadlineAdapter extends RecyclerView.Adapter<DeadlineAdapter.MyView>{

    public Integer[] images = {
            R.drawable.deadline1,
            R.drawable.deadline2,
            R.drawable.deadline3,
            R.drawable.deadline4,
    };

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.deadline_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyView extends RecyclerView.ViewHolder {



        public ImageView ivImage;
//        public TextView txtDiscout;
//        public TextView txtName;

        public MyView(View view) {
            super(view);
            ivImage = view.findViewById(R.id.ivImage);
//            txtDiscout = view.findViewById(R.id.txtDiscount);
//            txtName = view.findViewById(R.id.txtName);
        }
    }
}
