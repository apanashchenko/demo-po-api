package com.demo.api;

import com.demo.api.entity.User;
import com.demo.api.service.UserService;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static com.demo.api.RestClient.createService;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by alpa on 3/20/18
 */
public class UsersTest {

    private UserService userService = createService(UserService.class, "https", "my-json-server.typicode.com");

    @Test
    public void getUsers() throws IOException {
        List<User> userList = userService.getUsers().execute().body();
        assertThat(userList, hasSize(5));
    }

    @Test
    public void getSingleUser() throws IOException {
        int id = 1;
        String firstName = "Eve";
        String lastName = "Holt";

        User user = userService.getUser(id).execute().body();

        assertThat(user.getId(), is(id));
        assertThat(user.getFirstName(), is(firstName));
        assertThat(user.getLastName(), is(lastName));
        assertThat(user.getAvatar(), is(notNullValue()));
    }

    @Test
    public void createUserUser() throws IOException {
        User actualUser = new User();
        actualUser.setId(6);
        actualUser.setFirstName("Bob");
        actualUser.setLastName("Imbo");
        actualUser.setAvatar("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg");

        User expectedCreated = userService.createUser(actualUser).execute().body();

        assertThat(expectedCreated.getId(), is(actualUser.getId()));
        assertThat(expectedCreated.getFirstName(), is(actualUser.getFirstName()));
        assertThat(expectedCreated.getLastName(), is(actualUser.getLastName()));
        assertThat(expectedCreated.getAvatar(), is(actualUser.getAvatar()));
    }

    @Test
    public void updateUser() throws IOException {
        int id = 2;
        String testName = "TestName";
        String testLastName = "TestLastName";

        User user = userService.getUser(id).execute().body();

        user.setFirstName(testName);
        user.setLastName(testLastName);

        User expectedUser = userService.updateUser(id, user).execute().body();
        assertThat(expectedUser.getFirstName(), is(testName));
        assertThat(expectedUser.getLastName(), is(testLastName));
    }

    @Test
    public void deleteUser() throws IOException {
        int id = 3;

        User deleteUser = userService.deleteUser(id).execute().body();

        assertThat(deleteUser.getId(), is(0));
        assertThat(deleteUser.getFirstName(), is(nullValue()));
        assertThat(deleteUser.getLastName(), is(nullValue()));
        assertThat(deleteUser.getAvatar(), is(nullValue()));
    }

}
