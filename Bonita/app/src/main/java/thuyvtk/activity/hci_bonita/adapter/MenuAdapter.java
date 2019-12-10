package thuyvtk.activity.hci_bonita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;


import thuyvtk.activity.hci_bonita.R;
import thuyvtk.activity.hci_bonita.dtos.MenuItemDTO;

public class MenuAdapter extends BaseAdapter {
    ArrayList<MenuItemDTO> menus ;
    Context context;

    public MenuAdapter(ArrayList<MenuItemDTO> menus, Context context) {
        this.menus = menus;
        this.context = context;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       convertView = LayoutInflater.from(context).inflate(R.layout.menu_item,null);
        ImageView menu_icon = convertView.findViewById(R.id.menu_icon);
        menu_icon.setImageResource(menus.get(position).getImage());
        TextView title = convertView.findViewById(R.id.menu_title);
        title.setText(menus.get(position).getTitle());
        return convertView;
    }
}
