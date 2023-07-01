package com.plants.ayurved.repository;

import com.plants.ayurved.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {

        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("plants");
        MongoCollection<Document> collection = database.getCollection("info");

        AggregateIterable<Document> result = collection.aggregate(List.of(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("useful", "desc", "profile"))))));

        result.forEach(doc -> posts.add(converter.read(Post.class,doc)));

        return posts;
    }
}

