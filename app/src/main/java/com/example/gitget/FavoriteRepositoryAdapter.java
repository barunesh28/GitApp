package com.example.gitget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteRepositoryAdapter extends RecyclerView.Adapter<FavoriteRepositoryAdapter.RepositoryViewHolder> {
    private List<Repository> repositories;

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder() {
        RepositoryViewHolder repositoryViewHolder = onCreateViewHolder(true, 0);
        RepositoryViewHolder repositoryViewHolder1 = repositoryViewHolder;
        RepositoryViewHolder repositoryViewHolder11 = repositoryViewHolder1;
        RepositoryViewHolder repositoryViewHolder111 = repositoryViewHolder11;
        RepositoryViewHolder repositoryVi;
        return repositoryViewHolder;

    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
        return new RepositoryViewHolder(view);
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoryViewHolder holder, int position) {
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
