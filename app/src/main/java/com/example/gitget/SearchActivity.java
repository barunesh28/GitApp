package com.example.gitget;

import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.RecyclerView;

public class SearchActivity extends AppCompatActivity {
    private EditText searchEditText;
    private Button searchButton;
    private RecyclerView searchResultsRecyclerView;
    private RepositoryAdapter searchResultsAdapter;

    private GitHubApiClient gitHubApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView);

        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchResultsAdapter = new RepositoryAdapter();
        searchResultsRecyclerView.setAdapter(searchResultsAdapter);

        gitHubApiClient = new GitHubApiClient();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String query = searchEditText.getText().toString().trim();
        if (!query.isEmpty()) {
            try {
                List<Repository> searchResults = gitHubApiClient.searchRepositories(query);
                searchResultsAdapter.setRepositories(searchResults);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Failed to fetch search results", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}
