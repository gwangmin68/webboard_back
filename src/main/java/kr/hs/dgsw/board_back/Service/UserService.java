package kr.hs.dgsw.board_back.Service;

import kr.hs.dgsw.board_back.Domain.User;

import java.util.List;

public interface UserService {
    User userAdd(User user);
    User userView(Long id);
    User userView(String account);
    List<User> userList();
    User userUpdate(Long id, User user);
    boolean userDelete(Long id);
}
