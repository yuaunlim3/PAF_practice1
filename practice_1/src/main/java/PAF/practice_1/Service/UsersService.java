package PAF.practice_1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.practice_1.Model.Users;
import PAF.practice_1.Repository.UsersRepository;

@Service
public class UsersService {
    @Autowired private UsersRepository usersRepository;

    public Boolean checkUser(String username){
        return usersRepository.checkUser(username);
    }

    public void createUser(Users user){
        usersRepository.createUser(user);
    }

    public Users getUser(String username){
        return usersRepository.getUser(username);
    }
}
