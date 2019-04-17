package org.publicapis.api;

import com.relevantcodes.extentreports.LogStatus;
import framework.BaseTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiTest extends BaseTest {

    private static final String BASEURL = "https://api.publicapis.org/";
    private static final String COUNT = "count";
    private static final String ENTRIES = "entries";
    private static final String[] ENTRIES_FIELDS = new String[]{"API", "Description", "Auth", "HTTPS", "Cors", "Link", "Category"};
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(BASEURL)
            .log(LogDetail.ALL)
            .build();
    private ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();
    private Response response;

    @BeforeMethod(alwaysRun = true)
    public void before(Method method) {
        responseSpec.statusCode(200);
    }

    @BeforeClass
    public void init() {
        RestAssured.requestSpecification = requestSpec;
        RestAssured.responseSpecification = responseSpec;
    }


    @Test
    public void randomNoAuthTest() {
        test.log(LogStatus.INFO, "Testing request to /random endpoint with Auth='null' parameter ...");
        response = given().param("auth", "null").get(EndPoints.RANDOM);
        Map<String, Object> map = response.jsonPath().getMap("");
        assertTop(map);
        List<Map> list = response.jsonPath().getList(ENTRIES);
        test.log(LogStatus.INFO, "Checking that only one entry is returned...");
        Assert.assertEquals(list.size(), 1, "Too many entries");
        test.log(LogStatus.INFO, "Checking that 'count' is correct...");
        Assert.assertEquals(map.get(COUNT), 1, "'count' is wrong");
        map = list.get(0);
        assertLevelJson(map, ENTRIES_FIELDS);
        Assert.assertEquals(map.get(ENTRIES_FIELDS[2]), "");

    }

    @Test
    public void entriesTest() {
        test.log(LogStatus.INFO, "Testing request to /entries endpoint...");
        response = given().get(EndPoints.ENTRIES);
        Map<String, Object> map = response.jsonPath().getMap("");
        assertTop(map);
        List<Map> list = response.jsonPath().getList("entries");
        test.log(LogStatus.INFO, "Checking that 'count' is correct...");
        Assert.assertEquals(map.get("count"), list.size(), "'count' is wrong");
        Iterator<Map> iterator = list.iterator();
        while (iterator.hasNext()) {
            map = iterator.next();
            assertLevelJson(map, ENTRIES_FIELDS);
        }
    }


    @AfterMethod
    public void tearDown() {
        reports.endTest(test);
        reports.flush();
    }

    private void assertLevelJson(Map map, String[] fields) {
        for (int i = 0; i < fields.length; i++) {
            test.log(LogStatus.INFO, "Checking that API '" + map.get(ENTRIES_FIELDS[0]) + "' contains field " + fields[i]);
            Assert.assertTrue(map.containsKey(fields[i]), "Map : " + map.toString() + "does not contain Key " + fields[i]);
        }
    }

    private void assertTop(Map map) {
        test.log(LogStatus.INFO, "Checking that response contains field " + COUNT);
        Assert.assertTrue(map.containsKey(COUNT), "Response does not contain Key '" + COUNT + "'count'");
        test.log(LogStatus.INFO, "Checking that response contains field " + ENTRIES);
        Assert.assertTrue(map.containsKey(ENTRIES), "Response does not contain Key '" + ENTRIES + "'count'");
    }

    private final class EndPoints {
        private static final String RANDOM = "random";
        private static final String ENTRIES = "entries";
    }
}