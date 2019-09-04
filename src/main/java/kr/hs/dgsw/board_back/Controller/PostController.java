package kr.hs.dgsw.board_back.Controller;

import kr.hs.dgsw.board_back.Domain.Post;
import kr.hs.dgsw.board_back.Protocol.PostUsernameProtocol;
import kr.hs.dgsw.board_back.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/list")
    public List<PostUsernameProtocol> postList(){
        return this.postService.postList();
    }

    @GetMapping("/post/list/{kind}")
    public List<PostUsernameProtocol> postList(@PathVariable String kind){
        return this.postService.postList(kind);
    }

    @PostMapping("post/add")
    public PostUsernameProtocol postAdd(@RequestBody Post post){
        return this.postService.postAdd(post);
    }

    @GetMapping("/post/view/{id}")
    public PostUsernameProtocol postView(@PathVariable Long id){
        return this.postService.postView(id);
    }

    @PutMapping("/post/update/{id}")
    public PostUsernameProtocol updatePostById(@PathVariable Long id, @RequestBody Post post){
        return this.postService.postUpdate(id, post);
    }

    @DeleteMapping("/post/delete/{id}")
    public boolean deletePostById(@PathVariable Long id){
        return this.postService.postDelete(id);
    }
}
