package grimreaper.bookworm;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button signUp;
    Button signIn;
    private static CustomDrawerAdapter adapter;
    ArrayList<DrawerDataModel> drawerDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (Button)findViewById(R.id.signup);
        signUp.setOnClickListener(this);
        signIn = (Button)findViewById(R.id.signin);
        signIn.setOnClickListener(this);
        drawerDataModel= new ArrayList<>();

        drawerDataModel.add(new DrawerDataModel("Updates Feed", R.drawable.dashboard_white));
        drawerDataModel.add(new DrawerDataModel("My Books" , R.drawable.books_white));
        drawerDataModel.add(new DrawerDataModel("Scan Barcode" , R.drawable.scanner_white));

        adapter = new CustomDrawerAdapter(drawerDataModel , getApplicationContext());

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.leftDrawer);
        ListView listView = (ListView) findViewById(R.id.drawerList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.signin){
            Intent intent = new Intent(this , LoginActivity.class);
            startActivity(intent);
        }else if(view.getId() == R.id.signup){
            Intent intent = new Intent(this , RegisterActivity.class);
            startActivity(intent);
        }
    }
}
