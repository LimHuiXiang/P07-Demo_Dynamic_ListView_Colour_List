package sg.edu.rp.c346.id20006757.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etIndexElement;
    Button btnAdd;
    ListView lvColour;
    Button btnUpdate;
    Button btnRemove;


    ArrayList<String> alColours;
    ArrayAdapter<String> Colours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etElement = findViewById(R.id.editTextColour);
;        etIndexElement = findViewById(R.id.editTextIndex);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        btnUpdate = findViewById(R.id.buttonUpdateItem);
        btnRemove = findViewById(R.id.buttonRemoveItem);


        alColours = new ArrayList<>();
        alColours.add("Red");
        alColours.add("Orange");

        Colours = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(Colours);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ColourUser = etElement.getText().toString();
                //alColours.add(ColourUser);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.add(pos, ColourUser);
                Colours.notifyDataSetChanged();


            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, "Colour  clicked is: "+alColours.get(position)
                        , Toast.LENGTH_LONG).show();
                Log.d("LV click", colour);

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.remove(pos);
                Colours.notifyDataSetChanged();


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ColourUser = etElement.getText().toString();
                //alColours.add(ColourUser);
                int pos = Integer.parseInt(etIndexElement.getText().toString());
                alColours.set(pos, ColourUser);
                Colours.notifyDataSetChanged();


            }
        });



    }
}

