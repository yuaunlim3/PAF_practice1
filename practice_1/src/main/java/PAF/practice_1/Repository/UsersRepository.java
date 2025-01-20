package PAF.practice_1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF.practice_1.Model.Users;
import PAF.practice_1.Utils.SQL;

@Repository
public class UsersRepository {
    
    @Autowired private JdbcTemplate template;

    public Boolean checkUser(String username){
        int checkerUser = template.queryForObject(SQL.checkUser,Integer.class,username);
        if(checkerUser < 1){
            return false;
        }

        return true;
    }

    public void createUser(Users user){
        template.update(SQL.createUser,user.getUsername(),user.getPassword(),user.getEmail());
    }

    public Users getUser(String username){
        Users user = new Users();
        SqlRowSet rw = template.queryForRowSet(SQL.getUser,username);
        while (rw.next()) {
            user.setId(rw.getInt("id"));
            user.setUsername(rw.getString("username"));
            user.setPassword(rw.getString("password"));
            user.setEmail(rw.getString("email"));
        }

        return user;
    }
}
