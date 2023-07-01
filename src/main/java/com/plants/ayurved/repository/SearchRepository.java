package com.plants.ayurved.repository;

import com.plants.ayurved.model.Post;
import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
