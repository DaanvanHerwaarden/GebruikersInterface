package com.example.daan.gebruikersinterface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, Credits.CreditChangedListener, AdapterView.OnItemClickListener {

    Button buttonteller, buttonreset;
    TextView counterView;
    Credits credits;

    ListView mPersonListView;
    ArrayAdapter mArrayAdapter;
    PersonAdapter mPersonAdapter;
    ArrayList mPersonList = new ArrayList();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonteller = (Button) findViewById(R.id.buttonteller);
        buttonreset = (Button) findViewById(R.id.buttonreset);

        buttonteller.setOnClickListener(this);
        buttonreset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                credits.reset();
            }
        });


        counterView = (TextView) findViewById(R.id.counterView);
        Person p = new Person ();
        p.name = "The Joker"; p.age = "R.I.P."; p.email = "TheJoker@gmail.com";
        p.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.joker);
        mPersonList.add(p);

        p = new Person();
        p.name = "Bob Marley"; p.age = "R.I.P."; p.email = "DontWorry@gmail.com";
        p.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bob_marley2);
        mPersonList.add(p);

        p = new Person();
        p.name = "Jesse Pinkman"; p.age = "R.I.P."; p.email = "Hank_DEA@gmail.com";
        p.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.breaking);
        mPersonList.add(p);

        p = new Person();
        p.name = "Penguin"; p.age = "35"; p.email = "Penguin@gmail.com";
        p.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.penguin);
        mPersonList.add(p);

        mPersonListView = (ListView) findViewById(R.id.personListView);

        // Koppel list aan
        mPersonAdapter = new PersonAdapter(this,
                getLayoutInflater(),
                mPersonList);
        mPersonListView.setAdapter(mPersonAdapter);

        // Activate adapter, kan dan ook in een button, of network update
        mPersonAdapter.notifyDataSetChanged();

        // Enable listener
        mPersonListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("SelectedItem: ", position + "");
    }


    @Override
    public void onClick(View v) {
        credits.up();

    }

    @Override
    public void countChanged(int counter) {
        counterView.setText("" + counter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //
    // Click on selected item in list

}