package kr.hs.dgsw.board_back.Repository;

import kr.hs.dgsw.board_back.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByKind(String kind);
    List<Post> findByUserid(Long id);
}
