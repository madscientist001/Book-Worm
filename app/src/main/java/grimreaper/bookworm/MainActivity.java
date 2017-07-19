package grimreaper.bookworm;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener{

    ArrayList<DrawerDataModel> drawerDataModel;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting toolbar
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("BookWorm");

        //setting initial fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container , new HomeFragment());
        transaction.addToBackStack(null);
        transaction.commit();

        setContentView(R.layout.activity_main);

        //populating drawer
        drawerDataModel= new ArrayList<>();

        drawerDataModel.add(new DrawerDataModel("Updates Feed", R.drawable.dashboard_white));
        drawerDataModel.add(new DrawerDataModel("My Books" , R.drawable.books_white));
        drawerDataModel.add(new DrawerDataModel("Scan Barcode" , R.drawable.scanner_white));

        drawerLayout = (DrawerLayout)findViewById(R.id.leftDrawer);
        CustomDrawerAdapter adapter = new CustomDrawerAdapter(drawerDataModel, getApplicationContext());

        final ListView listView = (ListView) findViewById(R.id.drawerList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                HomeFragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                switch(position){
                    case 0:
                        Log.d("goku" , "selected 1");
                        args.putInt("img_res_id" , R.drawable.books_white);
                        fragment.setArguments(args);
                        transaction.replace(R.id.container , fragment);
                        break;
                    case 1:
                        Log.d("goku" , "selected 2");
                        args.putInt("img_res_id" , R.drawable.scanner_white);
                        fragment.setArguments(args);
                        transaction.replace(R.id.container , fragment);
                        break;
                    case 2:
                        Log.d("goku" , "selected 3");
                        args.putInt("img_res_id" , R.drawable.dashboard_white);
                        fragment.setArguments(args);
                        transaction.replace(R.id.container , fragment);
                        break;
                }
                transaction.addToBackStack(null);
                transaction.commit();
                listView.setItemChecked(position , true);
                setTitle(drawerDataModel.get(position).getName());
                drawerLayout.closeDrawer(listView);
            }
        });
    }

    @Override
    public void onButtonPressed(int button_id) {
        //for fragment communication with activity
        //Home Fragment tells activity which fragment it needs to be replaced with
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

    public void setTitle(String title){
        if(getActionBar() != null){
            getActionBar().setTitle(title);
        }
    }
}
