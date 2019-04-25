package sg.edu.rp.c346.p02_holidays;

import android.content.Context;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DayAdapter extends ArrayAdapter<Day> {

    private ArrayList<Day> day;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivDay;

    public DayAdapter(Context context, int resource, ArrayList<Day> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        day = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = rowView.findViewById(R.id.tvName);
        tvDate = rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivDay = rowView.findViewById(R.id.ivDay);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Day currentDay = day.get(position);
        // Set the TextView to show the food

    tvName.setText(currentDay.getName());
    tvDate.setText(currentDay.getDate());

        // Set the image to star or nostar accordingly
        if(currentDay.getType()=="Secular") {
            if (currentDay.isDay()) {
                ivDay.setImageResource(R.drawable.newyear);
            } else {
                ivDay.setImageResource(R.drawable.labour);
            }
        }

        else if(currentDay.getType()=="Ethnic") {
            if (currentDay.isDay()) {
                ivDay.setImageResource(R.drawable.cny);
            } else {
                ivDay.setImageResource(R.drawable.goodfriday);
            }
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
