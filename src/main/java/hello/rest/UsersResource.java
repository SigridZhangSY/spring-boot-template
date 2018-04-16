package hello.rest;

import hello.domain.User;
import hello.domain.UserRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/rest")
public class UsersResource {
    @Inject
    private UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public List<User> readAllUsers() {
        return userRepository.findAll();
    }
}
