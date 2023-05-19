package com.TodoProject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class TodoProject {
	
//	@Test()
	public void Resgister() {
		HashMap<String, String> registerHash=new HashMap<String, String>();
		registerHash.put("email", "mohammeeed.nimer.98@gmail.com");
		registerHash.put("firstName", "mmn");
		registerHash.put("lastName", "mmnn");
		registerHash.put("password", "Mo7star@");

		given().baseUri("https://todo.qacart.com/")
		.contentType(ContentType.JSON)
		.body(registerHash)
.log().all()
		.when().post("api/v1/users/register")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	}
	
//@Test()
public void Login() {
	File loginJson=new File("src/test/resources/login.json");
	
	
	given().baseUri("https://todo.qacart.com/")
	.contentType(ContentType.JSON)
	.body(loginJson)
	.log().all()
	
	.when().post("api/v1/users/login")
	
	.then()
	.assertThat().statusCode(200)
	.log().all();
}

//@Test()
public void addTodo(){
File add =new File("src/test/resources/addTodo.json");
	
	given().baseUri("https://todo.qacart.com/")
	.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0Njc2NTIzNzE5MjAzMDAxNGY4MDhhMSIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNjg0NDk5NTIzfQ.QjcOy32-Oa9p31BSFFG_rj5gXGduPQ4Nn_nRjyEL3Eo")
	.contentType(ContentType.JSON)
	.body(add)
	.log().all()
	
	.when().post("api/v1/tasks")
	.then()
	.assertThat().statusCode(201)
	.log().all()
	;
}


//@Test()
public void updateTodo() {
	File update =new File("src/test/resources/updateTodo.json");
	
	given().baseUri("https://todo.qacart.com/")
	.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0Njc5ZTE4NzE5MjAzMDAxNGY4MGI4OSIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNjg0NTE1MDc0fQ.JhZ9aFuqYPfLuZv2QBHaokG9HRqCiRP7y-x4vLaw78o")
	.contentType(ContentType.JSON)
	.body(update)
	.log().all()
	
	.when().put("api/v1/tasks/6467af3d7192030014f80d34")
	
	.then()
	.assertThat().statusCode(200)
	.log().all();
	
}

//@Test()
public void delete() {
	given().baseUri("https://todo.qacart.com/")
	.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjY0Njc5ZTE4NzE5MjAzMDAxNGY4MGI4OSIsImZpcnN0TmFtZSI6IkhhdGVtIiwiaWF0IjoxNjg0NTE1MDc0fQ.JhZ9aFuqYPfLuZv2QBHaokG9HRqCiRP7y-x4vLaw78o")

	.when().delete("api/v1/tasks/6467b2687192030014f80d7c")
	.then().log().all()
	.assertThat().statusCode(200);
	
}
}
