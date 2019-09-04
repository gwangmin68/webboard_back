package kr.hs.dgsw.board_back.Service;

import kr.hs.dgsw.board_back.Domain.Post;
import kr.hs.dgsw.board_back.Domain.User;
import kr.hs.dgsw.board_back.Repository.PostRepository;
import kr.hs.dgsw.board_back.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public User userAdd(User user) {
        Optional<User> found = this.userRepository.findByAccount(user.getAccount());
        if(found.isPresent()) return null;
        return this.userRepository.save(user);
    }

    @Override
    public User userView(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public User userView(String account) {
        return this.userRepository.findByAccount(account).orElse(null);
    }

    @Override
    public List<User> userList() {
        return this.userRepository.findAll();
    }

    @Override
    public User userUpdate(Long id, User user) {
        return this.userRepository.findById(id)
                .map(found -> {
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setGender(Optional.ofNullable(user.getGender()).orElse(found.getGender()));
                    found.setAge(Optional.ofNullable(user.getAge()).orElse(found.getAge()));
                    found.setProfile(Optional.ofNullable(user.getProfile()).orElse(found.getProfile()));
                    return this.userRepository.save(found);
                })
                .orElse(null);
    }

    @Override
    public boolean userDelete(Long id) {
        try{
            this.userRepository.deleteById(id);
            List<Post> posts = this.postRepository.findByUserid(id);
            posts.forEach(item -> {
                postRepository.deleteById(item.getId());
            });
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
