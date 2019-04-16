package hogwarts.workshop.util;

import com.github.mustachejava.DefaultMustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Message {

    /**
     * send HashMap body
     * @param data HashMap<String ,Object>
     * @return Response
     */
    public Response send(HashMap<String ,Object> data){
        return given()
                .log().all()
                .queryParam("access_token", Config.getInstance().access_token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all()
                .extract().response();
    }

    /**
     * send HashMap body
     * @param sBody body data type of String
     * @param url host and path
     * @return Response
     */
    public Response send(String url,String sBody){
        return given()
                .log().all()
                .queryParam("access_token", Config.getInstance().access_token)
                .contentType(ContentType.JSON)
                .body(sBody)
                .when()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }


    /**
     * send request by template generate
     */
    public Response send (String touser,String testcontent,Integer agentid){
        HashMap<String,Object> data = new HashMap<String, Object>();
        data.put("touser",touser);
        data.put("testcontent",testcontent);
        data.put("agentid",agentid);
        String sBody = template("data/message.json",data);
        Response response = send("https://qyapi.weixin.qq.com/cgi-bin/message/send",sBody);
        return response;
    }



    /**
     * template generate method
     */
    String template(String path,HashMap<String,Object> data){
        Writer writer = new StringWriter();
        new DefaultMustacheFactory().compile(path).execute(writer,data);
        return writer.toString();

    }

}
