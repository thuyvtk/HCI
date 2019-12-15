package thuyvtk.activity.hci_bonita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

import thuyvtk.activity.hci_bonita.R;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVTK> {

    private Integer[] listThumnail;

    public SliderAdapter(Integer[] listThumnail) {
        this.listThumnail = listThumnail;
    }

    @Override
    public SliderAdapterVTK onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null);
        return new SliderAdapterVTK(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVTK viewHolder, int position) {
        viewHolder.imageViewBackground.setImageResource(listThumnail[position]);
    }

    @Override
    public int getCount() {
        return listThumnail.length;
    }


    class SliderAdapterVTK extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVTK(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            this.itemView = itemView;
        }
    }
}
