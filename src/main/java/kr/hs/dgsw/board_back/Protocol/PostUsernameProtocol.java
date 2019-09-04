package kr.hs.dgsw.board_back.Protocol;

import kr.hs.dgsw.board_back.Domain.Post;

public class PostUsernameProtocol extends Post {
    private String username;

    public PostUsernameProtocol(String usernmae, Post post){
        super(post);
        this.username = username;
    }
}
