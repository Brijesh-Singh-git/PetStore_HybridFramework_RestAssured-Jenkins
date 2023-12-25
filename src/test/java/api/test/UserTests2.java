package api.test;

import api.endpoints.UserEndPoints;
import api.endpoints.UserEndPoints2;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests2 {

    Faker faker;
    User userpayload;
    public Logger logger;  //for logs


    @BeforeClass
    public void setupData(){

        faker= new Faker();
        userpayload = new User();


           userpayload.setId(faker.idNumber().hashCode());
           userpayload.setUsername(faker.name().username());
           userpayload.setFirstName(faker.name().firstName());
           userpayload.setLastName(faker.name().lastName());
           userpayload.setEmail(faker.internet().emailAddress());
           userpayload.setPassword(faker.internet().password());
           userpayload.setPhone(faker.phoneNumber().cellPhone());

           //Logs
            logger= LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser(){

        logger.info("************* Creating User ********************");

        Response response = UserEndPoints2.createUser(userpayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);


        logger.info("************* User is Created ********************");

    }

    @Test(priority = 2)
    public void testGetUser(){

        logger.info("************* Reading User Info ********************");

        Response response = UserEndPoints2.readUser(this.userpayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("************* User Info is displayed ********************");

    }

    @Test(priority = 3)
    public void testUpdateUser(){

        logger.info("************* Updating the User ********************");

        //Update the data using payload
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().emailAddress());

        Response response = UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        //Checking the data after update
        Response responseAfterUpdate = UserEndPoints2.readUser(this.userpayload.getUsername());
        responseAfterUpdate.then().log().all();

        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

        logger.info("************* User is updated ********************");

    }

    @Test(priority = 4)
    public void testDeleteUser(){

        logger.info("************* Deleting the User ********************");

        Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("************* User is deleted ********************");

    }
}
