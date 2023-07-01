package com.plants.ayurved.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String profile;
    private String desc;
    private String loc;
    private String[] useful;
}