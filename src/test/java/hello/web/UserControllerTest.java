package hello.web;

import hello.domain.User;
import hello.domain.UserRepository;

import hello.support.ApiUnitTest;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.when;

public class UserControllerTest extends ApiUnitTest {

    @Mock
    private UserRepository mockUserRepository;

    @InjectMocks
    UserController userController;

    @Before
    public void setUp() throws Exception {
        setUpApi(userController);
    }

    @Test
    public void should_return_200_when_get_user() throws Exception {
        User mockUser = new User(1L, "FirstName", "LastName");

        ArrayList<User> list = new ArrayList<User>();
        list.add(mockUser);

        when(mockUserRepository.findAll()).thenReturn(list);

        given().
                when().
                get("/users").
                then().
                statusCode(HttpStatus.SC_OK).
                body("firstName", hasItem("FirstName"));
    }
}
