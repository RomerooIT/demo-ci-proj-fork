package by.kulevets.demociproj.service;

import by.kulevets.demociproj.entity.model.PostModel;
import by.kulevets.demociproj.entity.pojo.PostPojo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    void create(PostPojo pojo);
    List<PostModel> getAll();
    PostModel getById(Long id);
}
