package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.OffsetDateTime;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String description;
    private String image;
    private OffsetDateTime createAt;
    private OffsetDateTime updateAt;
    private String createdBy;
    private String updatedBy;
}
