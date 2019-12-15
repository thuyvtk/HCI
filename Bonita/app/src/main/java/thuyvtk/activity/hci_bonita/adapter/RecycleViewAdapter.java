package thuyvtk.activity.hci_bonita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.activity.WomenServiceActivity;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyView> {

    Context context;

    public RecycleViewAdapter(Context context) {
        this.context = context;
    }

    public Integer[] types = {
      R.drawable.ic_woman_with_long_hair,
      R.drawable.ic_men_service,
      R.drawable.ic_nail_polish,
      R.drawable.ic_makeup,
      R.drawable.ic_spa,
    };

    public String[] typeNames = {
      "Tóc nữ",
      "Tóc nam",
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
    public void onBindViewHolder(@NonNull MyView holder, final int position) {
        holder.ivIcon.setImageResource(types[position]);
        holder.txtIconName.setText(typeNames[position]);
        holder.ivIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0 :
                        Intent intent = new Intent(context, WomenServiceActivity.class);
                        context.startActivity(intent);
                        break;
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageButton ivIcon;
        public TextView txtIconName;
        public LinearLayout lnIcon;

        public MyView(View view) {
            super(view);
            ivIcon = view.findViewById(R.id.ivIcon);
            txtIconName = view.findViewById(R.id.txtIconName);
            lnIcon = view.findViewById(R.id.lnIcon);
        }
    }
}
