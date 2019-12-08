package thuyvtk.activity.hci_bonita.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import thuyvtk.activity.hci_bonita.R;

public class TopLocationAdapter extends RecyclerView.Adapter<TopLocationAdapter.MyView> {
    private Integer[] images;
    private String[] names;

    public TopLocationAdapter(Integer[] images, String[] names) {
        this.images = images;
        this.names = names;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_location_layout, parent, false);
        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        holder.txtComment.setText("Nhân viên nhiêt tình, dễ thương, làm tóc đẹp mà chất lượng lắm, sẽ tiếp tục ủng hộ <3");
        holder.ivImg.setImageResource(images[position]);
        holder.txtName.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class MyView extends RecyclerView.ViewHolder {

        public ImageView ivImg;
        public TextView txtName;
        public TextView txtComment;

        public MyView(View view) {
            super(view);
            ivImg = view.findViewById(R.id.ivImg);
            txtName = view.findViewById(R.id.txtName);
            txtComment = view.findViewById(R.id.txtComment);
        }
    }
}
