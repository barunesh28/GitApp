package com.example.gitget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;
import java.util.Objects;

import static com.example.gitget.FavoriteRepositoryAdapter.*;
import static com.example.gitget.R.layout.repository_item;

public abstract class Repository  extends Adapter<RepositoryViewHolder> implements Repository2 {
    public static List<Repository> repositories = null;

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
        notifyDataSetChanged();
    }

    /**
     *
     */
    public void notifyDataSetChanged() {
        Switch

    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder() {
        return onCreateViewHolder(null, 0);
    }

    @NonNull
    @Override
    public RepositoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(repository_item, Objects.requireNonNull(parent), false);
        return new RepositoryViewHolder(view);
    }

    private int getName() {
        return 0;
    }

    private Object getDescription() {
        Object o = null;
        return o;
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

