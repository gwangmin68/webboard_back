package kr.hs.dgsw.board_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동 증가값
    private Long id;

    private String title;
    private Long userid;
    private String content;
    private String kind;
    private int cntRecommend;
    private int cntInquiry;

    @CreationTimestamp
    private LocalDateTime created;

    public Post(String title, Long userid, String content, String kind){
        this.title = title;
        this.userid = userid;
        this.content = content;
        this.kind = kind;
        this.cntRecommend = 0;
        this.cntInquiry = 0;
    }
    public Post(Post post){
        this.id = post.id;
        this.title = post.title;
        this.userid = post.userid;
        this.content = post.content;
        this.kind = post.kind;
        this.cntRecommend = post.cntRecommend;
        this.cntInquiry = post.cntInquiry;
        this.created = post.created;
    }
}
