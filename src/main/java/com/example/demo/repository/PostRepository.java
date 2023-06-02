package com.example.demo.repository;

import com.example.demo.model.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    List<Post> findAll();
}
