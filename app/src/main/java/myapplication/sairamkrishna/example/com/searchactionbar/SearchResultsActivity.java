package myapplication.sairamkrishna.example.com.searchactionbar;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchResultsActivity extends AppCompatActivity {

    //dummy logika:
    private static String[] towns = {"Zagreb", "Zadar", "Split", "Slavonski Brod", "Požega"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY); //QUERY je upit
            String result = search(query);

            Toast.makeText(SearchResultsActivity.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    //search je promjenjiv
    private String search(String query) {
        StringBuilder sb = new StringBuilder();
        for (String town: towns) {
            if (town.toLowerCase().startsWith(query.toLowerCase())) {
                sb.append(town + "\n");
            }
        }
        return sb.toString();
    }
}
