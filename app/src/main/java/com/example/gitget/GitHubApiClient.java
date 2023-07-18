package com.example.gitget;

import android.app.DownloadManager;
import android.os.Build;
import android.view.textclassifier.ConversationActions;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.android.volley.Response;

import javax.security.auth.callback.Callback;
import java.io.IOException;
import java.util.List;

public interface GitHubApiClient {

        private static final String BASE_URL = "https://api.github.com/";

        private OkHttpClient client;
        private Gson gson;

        public GitHubApiClient() {
            client = new OkHttpClient();
            gson = new Gson();
        }

        @RequiresApi(api = Build.VERSION_CODES.Q)
        public default void searchRepositories(String query, final SearchCallback callback) {
            String url = BASE_URL + "search/repositories?q=" + query;
            DownloadManager.Request request = new ConversationActions.Request.Builder()
                    .url(url)
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    callback.onFailure(e.getMessage());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    if (response.isSuccessful()) {
                        String responseBody = response.body().string();
                        response.close();

                        RepositoryResponse repositoryResponse = gson.fromJson(responseBody, RepositoryResponse.class);
                        List<Repository> repositories = repositoryResponse.getRepositories();
                        callback.onRepositoriesFetched(repositories);
                    } else {
                        callback.onFailure(response.equals());
                    }
                }
            });
        }

        public interface SearchCallback {
            void onRepositoriesFetched(List<Repository> repositories);
            void onFailure(String errorMessage);
        }
    }

