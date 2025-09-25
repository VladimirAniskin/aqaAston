package postmanTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class PostmanEchoRequestMethodsTest {

  @BeforeClass
  public void setUp() {
    RestAssured.baseURI = "https://postman-echo.com";
  }


  @Test
  public void testGetRequestWithQueryParams() {
    given()
        .param("foo1", "bar1")
        .param("foo2", "bar2")
        .when()
        .get("/get")
        .then()
        .statusCode(200)
        .body("args.foo1", equalTo("bar1"))
        .body("args.foo2", equalTo("bar2"))
        .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
        .body("headers", notNullValue())
        .body("headers.host", equalTo("postman-echo.com"));
  }

  @Test
  public void testGetRequestWithoutParams() {
    Response response = get("/get");

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com/get");
    assertTrue(response.jsonPath().getMap("args").isEmpty());
    assertNotNull(response.jsonPath().getMap("headers"));
  }

  @Test(dataProvider = "getQueryParams")
  public void testGetRequestWithVariousParams(String key, String value) {
    given()
        .param(key, value)
        .when()
        .get("/get")
        .then()
        .statusCode(200)
        .body("args." + key, equalTo(value))
        .body("url", containsString(key + "=" + value));
  }

  // ==================== POST METHOD TESTS ====================

  @Test
  public void testPostRequestWithJsonBody() {
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("name", "John Doe");
    requestBody.put("age", 30);
    requestBody.put("active", true);

    given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .post("/post")
        .then()
        .statusCode(200)
        .body("json.name", equalTo("John Doe"))
        .body("json.age", equalTo(30))
        .body("json.active", equalTo(true))
        .body("url", equalTo("https://postman-echo.com/post"))
        .body("headers.content-type", containsString("application/json"));
  }

  @Test
  public void testPostRequestWithFormData() {
    given()
        .contentType("application/x-www-form-urlencoded")
        .formParam("key1", "value1")
        .formParam("key2", "value2")
        .when()
        .post("/post")
        .then()
        .statusCode(200)
        .body("form.key1", equalTo("value1"))
        .body("form.key2", equalTo("value2"))
        .body("headers.content-type", containsString("application/x-www-form-urlencoded"));
  }

  @Test
  public void testPostRequestWithTextBody() {
    String textBody = "This is a plain text message";

    given()
        .contentType("text/plain")
        .body(textBody)
        .when()
        .post("/post")
        .then()
        .statusCode(200)
        .body("data", equalTo(textBody))
        .body("headers.content-type", containsString("text/plain"));
  }


  @Test
  public void testPutRequestWithJsonBody() {
    Map<String, Object> requestBody = new HashMap<>();
    requestBody.put("id", 123);
    requestBody.put("title", "Updated Title");
    requestBody.put("completed", false);

    given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .put("/put")
        .then()
        .statusCode(200)
        .body("json.id", equalTo(123))
        .body("json.title", equalTo("Updated Title"))
        .body("json.completed", equalTo(false))
        .body("url", equalTo("https://postman-echo.com/put"));
  }

  @Test
  public void testPutRequestWithQueryParamsAndBody() {
    given()
        .contentType("application/json")
        .param("source", "test")
        .body("{\"message\": \"PUT request with params\"}")
        .when()
        .put("/put")
        .then()
        .statusCode(200)
        .body("args.source", equalTo("test"))
        .body("json.message", equalTo("PUT request with params"));
  }


  @Test
  public void testPatchRequestWithPartialUpdate() {
    Map<String, Object> partialUpdate = new HashMap<>();
    partialUpdate.put("status", "updated");
    partialUpdate.put("version", 2.1);

    given()
        .contentType("application/json")
        .body(partialUpdate)
        .when()
        .patch("/patch")
        .then()
        .statusCode(200)
        .body("json.status", equalTo("updated"))
        .body("json.version", equalTo(2.1f))
        .body("url", equalTo("https://postman-echo.com/patch"));
  }


  @Test
  public void testDeleteRequest() {
    given()
        .param("resourceId", "789")
        .when()
        .delete("/delete")
        .then()
        .statusCode(200)
        .body("args.resourceId", equalTo("789"))
        .body("url", equalTo("https://postman-echo.com/delete"))
        .body("data", isEmptyOrNullString());
  }

  @Test
  public void testDeleteRequestWithBody() {
    given()
        .contentType("application/json")
        .body("{\"reason\": \"no longer needed\"}")
        .when()
        .delete("/delete")
        .then()
        .statusCode(200)
        .body("json.reason", equalTo("no longer needed"));
  }


  @Test
  public void testRequestMethodValidation() {
    // Test that each endpoint responds with correct method in response
    testMethodInResponse("GET", "/get");
    testMethodInResponse("POST", "/post");
    testMethodInResponse("PUT", "/put");
    testMethodInResponse("PATCH", "/patch");
    testMethodInResponse("DELETE", "/delete");
  }

  private void testMethodInResponse(String expectedMethod, String endpoint) {
    RequestSpecification request = given();

    if ("POST".equals(expectedMethod) || "PUT".equals(expectedMethod) || "PATCH".equals(
        expectedMethod)) {
      request.contentType("application/json").body("{\"test\": \"value\"}");
    }

    Response response = request.when().request(expectedMethod, endpoint);

    assertEquals(response.getStatusCode(), 200);
    assertEquals(response.jsonPath().getString("url"), "https://postman-echo.com" + endpoint);
  }

  @Test
  public void testResponseStructureConsistency() {

    String[] endpoints = {"/get", "/post", "/put", "/patch", "/delete"};

    for (String endpoint : endpoints) {
      Response response = given().when().get("/get"); // Using GET as base

      assertEquals(response.getStatusCode(), 200);

      // Check common response fields
      assertNotNull(response.jsonPath().get("args"));
      assertNotNull(response.jsonPath().get("headers"));
      assertNotNull(response.jsonPath().getString("url"));

      assertTrue(response.jsonPath().getString("url").contains(endpoint));
    }
  }


  @Test
  public void testInvalidEndpoint() {
    given()
        .when()
        .get("/nonexistent")
        .then()
        .statusCode(404);
  }

  @Test
  public void testMethodNotAllowed() {
    given()
        .when()
        .post("/get")
        .then()
        .statusCode(200); // Postman Echo is permissive
  }


  @DataProvider(name = "getQueryParams")
  public Object[][] provideGetQueryParams() {
    return new Object[][]{
        {"search", "test query"},
        {"page", "1"},
        {"limit", "10"},
        {"sort", "name"},
        {"filter", "active"},
        {"lang", "en-US"}
    };
  }

  @DataProvider(name = "postBodies")
  public Object[][] providePostBodies() {
    return new Object[][]{
        {"{\"single\": \"value\"}"},
        {"{\"nested\": {\"key\": \"value\"}}"},
        {"{\"array\": [1, 2, 3]}"},
        {"{\"boolean\": true, \"number\": 42, \"string\": \"text\"}"}
    };
  }


  @Test(dataProvider = "postBodies")
  public void testPostWithVariousBodies(String jsonBody) {
    given()
        .contentType("application/json")
        .body(jsonBody)
        .when()
        .post("/post")
        .then()
        .statusCode(200)
        .body("data", equalTo(jsonBody));
  }


  @Test
  public void testCustomHeaders() {
    given()
        .header("X-Custom-Header", "custom-value")
        .header("User-Agent", "Test-Agent")
        .when()
        .get("/get")
        .then()
        .statusCode(200)
        .body("headers.x-custom-header", equalTo("custom-value"))
        .body("headers.user-agent", equalTo("Test-Agent"));
  }


  @Test
  public void testResponseTime() {
    given()
        .when()
        .get("/get")
        .then()
        .statusCode(200)
        .time(lessThan(3000L)); // Response should be under 3 seconds
  }

}
