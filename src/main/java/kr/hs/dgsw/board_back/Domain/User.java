package kr.hs.dgsw.board_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//자동 증가값
    private Long id;
    private String name;
    private String account;
    private String password;
    private String gender;
    private int cntRecommend;
    private int age;
    private String profile;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public User(String name, String account, String password, String gender, int age){
        this.name = name;
        this.account = account;
        this.password = password;
        this.gender = gender;
        this.cntRecommend = 0;
        this.age = age;
    }

    public User(String name, String account, String password, String gender, int age, String profile){
        this.name = name;
        this.account = account;
        this.password = password;
        this.gender = gender;
        this.cntRecommend = 0;
        this.age = age;
        this.profile = profile;
    }
}
