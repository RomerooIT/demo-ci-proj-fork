package by.kulevets.demociproj.service;

import by.kulevets.demociproj.entity.model.PostModel;
import by.kulevets.demociproj.entity.pojo.PostPojo;
import by.kulevets.demociproj.mapper.Mapper;
import by.kulevets.demociproj.repository.PostRepository;
import by.kulevets.demociproj.repository.RedisPostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class DefaultPostService implements PostService {

    private static final String POSTS_KEY = "posts";

    private final PostRepository postRepository;
    private final RedisPostRepository redisPostRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final Mapper mapper;

    @Override
    public void create(PostPojo pojo) {
        PostModel model = postRepository.save(mapper.toModel(pojo));
        PostModel cached = getById(model.getId());
        if (cached == null) {
            redisTemplate.opsForHash()
                            .put(POSTS_KEY, model.getId(), model);
            postRepository.save(model);
        }
    }

    @Override
    public List<PostModel> getAll() {
        Spliterator<PostModel> cachedSpliterator = redisPostRepository.findAll().spliterator();
        if (cachedSpliterator.estimateSize() > 0){
            return StreamSupport.stream(cachedSpliterator, true)
                    .toList();
        }
        return postRepository.findAll();
    }

    @Override
    public PostModel getById(Long id) {
        return (PostModel) redisTemplate.opsForHash()
                .get(POSTS_KEY, id);
    }
}
