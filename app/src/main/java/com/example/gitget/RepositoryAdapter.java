package com.example.gitget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface RepositoryAdapter {


    public class FavoriteRepositoryAdapter extends RecyclerView.Adapter<com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder> {
        private List<Repository> repositories;

        public void setRepositories(List<Repository> repositories) {
            this.repositories = repositories;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder onCreateViewHolder() {
            com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder repositoryViewHolder = onCreateViewHolder(null, 0);
            com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder repositoryViewHolder1 = repositoryViewHolder;
            com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder repositoryViewHolder11 = repositoryViewHolder1;
            com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder repositoryViewHolder111 = repositoryViewHolder11;
            com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder repositoryVi;
            return repositoryViewHolder;

        }

        @NonNull
        @Override
        public com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
            return new com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder(view);
        }

        @NonNull
        @Override
        public com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.gitget.FavoriteRepositoryAdapter.RepositoryViewHolder holder, int position) {
            Repository repository = repositories.get(position);
            holder.repoNameTextView.setText(repository.getName());
            holder.repoDescriptionTextView.setText(repository.getDescription());

            // Set other details as needed
        }

        @Override
        public int getItemCount() {
            return repositories != null ? repositories.size() : 0;
        }

        public static class RepositoryViewHolder extends RecyclerView.ViewHolder {
            public TextView repoNameTextView;
            public TextView repoDescriptionTextView;

            public RepositoryViewHolder(@NonNull View itemView) {
                super(itemView);
                repoNameTextView = itemView.findViewById(R.id.repoNameTextView);
                repoDescriptionTextView = itemView.findViewById(R.id.repoDescriptionTextView);
            }
        }
    }

}
