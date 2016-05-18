package myapplication.sairamkrishna.example.com.searchactionbar;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu je genericki objekt!
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_menu, menu);
        initSearch(menu);
        return true;
    }

    private void initSearch(Menu menu) {
        //SENZOR JE SISTEMSKI SERVIS
        //Search servis je ugraden u sustav kao system service
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        //Inicijaliziramo objekt tipa SearchView:
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        //
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
    }
}
