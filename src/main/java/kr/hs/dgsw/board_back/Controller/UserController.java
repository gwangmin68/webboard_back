package kr.hs.dgsw.board_back.Controller;

import kr.hs.dgsw.board_back.Domain.User;
import kr.hs.dgsw.board_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/list")
    public List<User> userList(){
        return this.userService.userList();
    }

    @PostMapping("/user/add")
    public User userAdd(@RequestBody User user){
        return this.userService.userAdd(user);
    }

    @GetMapping("/user/view/{id}")
    public User userView(@PathVariable Long id){
        return this.userService.userView(id);
    }

    @GetMapping("/user/view/ac/{account}")
    public User userView(@PathVariable String account){
        return this.userService.userView(account);
    }

    @PutMapping("/user/update/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user){
        return this.userService.userUpdate(id, user);
    }

    @DeleteMapping("/user/delete/{id}")
    public boolean deleteUserById(@PathVariable Long id){
        return this.userService.userDelete(id);
    }
}