package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import thuyvtk.activity.hci_bonita.R;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyView> {

    public Integer[] types = {
      R.drawable.ic_woman_with_long_hair,
      R.drawable.ic_men_service,
      R.drawable.ic_nail_polish,
      R.drawable.ic_makeup,
      R.drawable.ic_spa,
    };

    public String[] typeNames = {
      "Nữ",
      "Nam",
      "Nails",
      "Trang điểm",
      "Spa"
    };
    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.ivIcon.setImageResource(types[position]);
        holder.txtIconName.setText(typeNames[position]);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageButton ivIcon;
        public TextView txtIconName;

        public MyView(View view) {
            super(view);
            ivIcon = view.findViewById(R.id.ivIcon);
            txtIconName = view.findViewById(R.id.txtIconName);
        }
    }
}
