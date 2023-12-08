package ElkSpringLogger.controller;

import ElkSpringLogger.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
@RestController
public class UserController {


    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id")int  id){
        List<User>  userList=getUser();
        User user=userList.stream().filter(u->u.getId()==id).findAny().orElse(null);
        if(user!=null){

            log.info("user found"+user);
            return user;
        }
        else{
            try {

                throw new Exception();
            }
            catch (Exception e){
                log.error("User Not found "+id);
            }
            return new User();

        }

    }



    private List<User> getUser() {
        return Stream.of(new User(1,"dinesh"),
                new User(2,"Sridhar"),
                new User(3,"bharat"))
                .collect(Collectors.toList());

    }
}
