package ru.koshelev.api.test;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.koshelev.api.payloads.UserPayloads;
import ru.koshelev.api.responces.UserRegistrationResponse;
import ru.koshelev.api.services.UserApiService;




import static org.hamcrest.Matchers.equalTo;
import static ru.koshelev.api.conditions.Conditions.*;


public class UserApiTest extends BeforeUsersTest {

    private final UserApiService userApiService = new UserApiService();


//
@DisplayName("Получение юзера по ID")
    @Test
    public void getUserAndCheckById() {
        userApiService.getUsers()
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("data[0].id", equalTo(7)));

    }
@DisplayName("Проверка создания юзера")
    @Test
    public void createUser() {
        //given
        UserPayloads user = new UserPayloads()
                .name(faker.name().fullName())
                .job(faker.job().position());
        //expect
       UserRegistrationResponse userRegistrationResponse= userApiService.registerUser(user)
                .shouldHave(statusCode(201))
        .asPojo(UserRegistrationResponse.class);
        System.out.println("URR: "+userRegistrationResponse.getName());
        System.out.println("U:  "+user.name());


    }
}
