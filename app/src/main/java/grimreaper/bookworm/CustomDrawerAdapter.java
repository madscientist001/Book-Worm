package grimreaper.bookworm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kanchan on 10-06-2017.
 */
public class CustomDrawerAdapter extends ArrayAdapter<DrawerDataModel>{

    public CustomDrawerAdapter(ArrayList<DrawerDataModel> data , Context context) {
        super(context , R.layout.rowlayout , data);
    }

    private static class ViewHolder {
        TextView name;
        ImageView icon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DrawerDataModel drawerDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rowlayout, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.label);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(drawerDataModel.getName());
        viewHolder.icon.setImageResource(drawerDataModel.getIcon());
        // Return the completed view to render on screen
        return convertView;
    }
}
