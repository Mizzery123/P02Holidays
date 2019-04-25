package sg.edu.rp.c346.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayAdapter aa;
    ArrayList<Day> day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvDays);
        tvYear = (TextView) findViewById(R.id.tvDays);

        day = new ArrayList<Day>();

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tvYear.setText(type);


if(type.equals("Secular")) {
    day.add(new Day("New Year's Day", "1 Jan 2017", true, "Secular"));
    day.add(new Day("Labour Day", "1 May 2017", false, "Secular"));
} else {
    day.add(new Day("Chinese New Year", "28-29 Jan 2017", true, "Ethnic"));
    day.add(new Day("Good Friday", "14 April 2017", false, "Ethnic"));
}

        aa = new DayAdapter(this, R.layout.row, day);
        lv.setAdapter(aa);



        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Day selectedDay = day.get(position);

                Toast.makeText(SecondActivity.this, selectedDay.getName()
                                + " Date: " + selectedDay.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
