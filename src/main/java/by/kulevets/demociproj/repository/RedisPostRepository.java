package by.kulevets.demociproj.repository;

import by.kulevets.demociproj.entity.model.PostModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisPostRepository extends CrudRepository<PostModel, Long> {
}
