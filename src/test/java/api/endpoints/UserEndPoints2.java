package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

// It will contain the CRUD(Create, Retrieve, Update, Delete) requests for the user API

public class UserEndPoints2 {

        //method created for getting the URL's from properties file
        static ResourceBundle getURL(){

            ResourceBundle routes = ResourceBundle.getBundle("routes");  //Load Properties file
            return routes;
        }

        public static Response createUser(User payload)
        {
            String post_url = getURL().getString("post_url");

            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(payload)

                    .when()
                        .post(post_url);

            return response;

        }


    public static Response readUser(String userName)
    {
        String get_url = getURL().getString("get_url");

        Response response = given()
                .pathParams("username", userName)

                .when()
                    .get(get_url);

        return response;

    }


    public static Response updateUser(String userNane, User payload)
    {

        String update_url = getURL().getString("update_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .pathParams("username", userNane)

                .when()
                .put(update_url);

        return response;

    }


    public static Response deleteUser(String userName)
    {

        String delete_url = getURL().getString("delete_url");


        Response response = given()
                .pathParams("username", userName)

                .when()
                .delete(delete_url);

        return response;

    }

}
