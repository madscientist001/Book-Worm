package grimreaper.bookworm;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import layout.HomeFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener{

    private static CustomDrawerAdapter adapter;
    ArrayList<DrawerDataModel> drawerDataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager manager = (FragmentManager)getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container , new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();

        setContentView(R.layout.activity_main);

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
    public void onButtonPressed(int button_id) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (button_id) {
            case R.id.signin :
                transaction.replace(R.id.container , new SignInFragment());
                break;
            case R.id.signup :
                transaction.replace(R.id.container , new SignUpFragment());
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
