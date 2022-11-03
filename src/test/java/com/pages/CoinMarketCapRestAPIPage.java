package com.pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.testng.Assert;
import java.util.*;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class CoinMarketCapRestAPIPage
{
   // final Logger logger = LoggerFactory.getLogger(restApiTest.class);
    public HashSet<Boolean> flagList=new HashSet<>();
    public Response response;
    public List<String> l1;
    List<HashMap<Object, Object>> jsonResponse;

    public void getRequest() {
        RestAssured.defaultParser = Parser.JSON;
        RestAssured.baseURI = "https://pro-api.coinmarketcap.com/v1";
        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "7efe84d1-b52c-4ca4-8aab-3210a2aad309")
                .when()
                .get("/cryptocurrency/map")
                .then()
                .extract().response();
    }

    public void retrieveJsonResponse(String cur1,String cur2,String cur3) {
        Assert.assertEquals(200, response.statusCode());
        jsonResponse = response.jsonPath().getList("data");
        System.out.println(jsonResponse.size());
        l1 = jsonResponse.stream().filter(s->
                s.get("name").toString().equals(cur1) || s.get("name").toString().equals(cur2)
                        || s.get("name").toString().equals(cur3)
        ).map(s->s.get("id").toString()).collect(Collectors.toList());
        l1.forEach(e -> System.out.println("id : "+e));
    }

    public void convertIdsToBoli(String convert) {
        List<String> l2 = l1.stream().map(s -> {
                    return given()
                            .contentType(ContentType.JSON)
                            .header("X-CMC_PRO_API_KEY", "7efe84d1-b52c-4ca4-8aab-3210a2aad309")
                            .param("amount", "1")
                            .param("convert", convert)
                            .param("id", s)
                            .when()
                            .get("/tools/price-conversion")
                            .then()
                            .extract().response().jsonPath().get("data.quote.BOLI.price").toString();
                }
        ).collect(Collectors.toList());
        l2.forEach(e -> System.out.println("converted BOLI prices : "+e));
        Assert.assertEquals(200, response.statusCode());

    }


    public void getRequestForGivenId(String ID) {

        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "7efe84d1-b52c-4ca4-8aab-3210a2aad309")
                .param("id", ID)
                .when()
                .get("/cryptocurrency/info")
                .then()
                .extract().response();
       // logger.info(response.jsonPath().get("data.1027.urls.website").toString());
        List<Object> ll = response.jsonPath().get("data.1027.urls.website");
        Assert.assertTrue(ll.size()>0);
    }


    public void valiateJsonResponseforID(String val1,String val2,String val3,String val4,String val5) {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(val1, response.jsonPath().get("data.1027.logo").toString());
        Assert.assertEquals(val2, response.jsonPath().getList("data.1027.urls.technical_doc").get(0).toString());
        System.out.println(response.jsonPath().get("data.1027.urls.technical_doc").toString());
        Assert.assertEquals(val3, response.jsonPath().get("data.1027.symbol").toString());
        Assert.assertEquals(val4, response.jsonPath().get("data.1027.date_added").toString());
        try{
            Assert.assertTrue(response.jsonPath().getList("data.1027.tags").contains(val5));

        }catch (Exception e) {
            System.out.println("tags: [ mineable ] is not associated! Hence test will fail");
            e.printStackTrace();

        }

    }

    public void getFirstTenCryptoCurrencies(){
        response = given()
                .contentType(ContentType.JSON)
                .header("X-CMC_PRO_API_KEY", "7efe84d1-b52c-4ca4-8aab-3210a2aad309")
                .param("id", "1,2,3,4,5,6,7,8,9,10")
                .when()
                .get("/cryptocurrency/info")
                .then()
                .extract().response();
        Assert.assertEquals(200, response.statusCode());
        Map<Object,HashMap<Object,Object>> jResponse = response.jsonPath().getMap("data");
        List<Object> newL = new ArrayList<>();
        jResponse.forEach(
                (i,j)->{
                    if(j.get("tags").toString().contains("mineable"))
                        System.out.println(j.get("name")+" tag: "+j.get("tags"));
                    newL.add(j.get("name"));
                }
        );

        for (Map.Entry<Object,HashMap<Object,Object>> entry : jResponse.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().get("tags")+ ":" + entry.getValue().get("name"));
            if(newL.contains(entry.getValue().get("name").toString())){
                flagList.add(true);
            }else{
                flagList.add(false);
            }
        }
    }

    public void cryptocurrencyValidation(){
        Boolean flag = true;
        if(flagList.contains(false)){
            flag=false;
        }
        Assert.assertTrue(flag);
    }
}
