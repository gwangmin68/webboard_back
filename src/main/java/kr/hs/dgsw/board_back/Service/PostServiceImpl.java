package kr.hs.dgsw.board_back.Service;

import kr.hs.dgsw.board_back.Domain.Post;
import kr.hs.dgsw.board_back.Domain.User;
import kr.hs.dgsw.board_back.Protocol.PostUsernameProtocol;
import kr.hs.dgsw.board_back.Repository.PostRepository;
import kr.hs.dgsw.board_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PostUsernameProtocol postAdd(Post post) {
        return new PostUsernameProtocol(this.userRepository.findById(post.getUserid()).get().getName(), this.postRepository.save(post));
    }

    @Override
    public PostUsernameProtocol postView(Long id) {
        Post post = this.postRepository.findById(id).get();
        return new PostUsernameProtocol(this.userRepository.findById(post.getUserid()).get().getName(), post);
    }

    @Override
    public List<PostUsernameProtocol> postList() {
        List<Post> postList = this.postRepository.findAll();
        List<PostUsernameProtocol> pupList = new ArrayList<>();
        postList.forEach(post -> {
            Optional<User> found = this.userRepository.findById(post.getUserid());
            String username= found.isPresent() ? found.get().getName() : null;
            pupList.add(new PostUsernameProtocol(username, post));
        });
        return pupList;
    }

    @Override
    public List<PostUsernameProtocol> postList(String kind) {
        List<Post> postList = this.postRepository.findByKind(kind);
        List<PostUsernameProtocol> pupList = new ArrayList<>();
        postList.forEach(post-> {
            Optional<User> found = this.userRepository.findById(post.getUserid());
            String username = found.isPresent() ? found.get().getName() : null;
            pupList.add(new PostUsernameProtocol(username, post));
        });
        return pupList;
    }

    @Override
    public PostUsernameProtocol postUpdate(Long id, Post post) {
        this.postRepository.findById(id)
            .map(found -> {
                found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                found.setUserid(Optional.ofNullable(post.getUserid()).orElse(found.getUserid()));
                found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                found.setCntRecommend(Optional.ofNullable(post.getCntRecommend()).orElse(found.getCntRecommend()));
                found.setCntInquiry(Optional.ofNullable(post.getCntInquiry()).orElse(found.getCntInquiry()));
                return this.postRepository.save(found);
            })
            .orElse(null);
        return new PostUsernameProtocol(this.userRepository.findById(post.getUserid()).get().getName(), post);
    }

    @Override
    public boolean postDelete(Long id) {
        try{
            this.postRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
