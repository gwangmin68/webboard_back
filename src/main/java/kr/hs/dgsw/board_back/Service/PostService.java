package kr.hs.dgsw.board_back.Service;

import kr.hs.dgsw.board_back.Domain.Post;
import kr.hs.dgsw.board_back.Protocol.PostUsernameProtocol;

import java.util.List;

public interface PostService {
    PostUsernameProtocol postAdd(Post post);
    PostUsernameProtocol postView(Long id);
    List<PostUsernameProtocol> postList();
    List<PostUsernameProtocol> postList(String kind);
    PostUsernameProtocol postUpdate(Long id, Post post);
    boolean postDelete(Long id);
}
