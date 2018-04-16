package hello.web;

import hello.domain.User;
import hello.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(method = GET, produces = "application/json")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }
}