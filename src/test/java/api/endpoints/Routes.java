package api.endpoints;

        //All the URLs will be kept under this
/*
Swagger URL --> https://petstore.swagger.io
Base URL: --->  https://petstore.swagger.io/v2


Create User --> https://petstore.swagger.io/v2/user
Get User --->   https://petstore.swagger.io/v2/user/{username}
Update User --> https://petstore.swagger.io/v2/user/{username}
Delete User --> https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {

    public static String base_url = "https://petstore.swagger.io/v2";

    //User Module
    public static String post_url = base_url+"/user";
    public static String get_url = base_url+"/user/{username}";
    public static String update_url = base_url+"/user/{username}";
    public static String delete_url = base_url+"/user/{username}";


    //Store Module
    //Create Store module URL here

    //Pet Module
    //Create Pet module URL here



}
