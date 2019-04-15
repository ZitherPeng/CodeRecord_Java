package hogwarts.workshop.util;

import com.github.mustachejava.DefaultMustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Message {

    /**
     * send 基础实现
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
     * 模版生成 data
     */
    public Response send (String to,String msg) throws IOException {
        Writer writer = new OutputStreamWriter(System.out);
        HashMap<String,Object> data = new HashMap<String, Object>();
        data.put("to","@all");
        data.put("msg","你的快递已到");
        new DefaultMustacheFactory().compile("data/message.json").execute(writer,data);
        writer.flush();
        return send(data);
    }
    public void send (String data){
        given()
                .log().all()
                .queryParam("access_token",Config.getInstance().access_token);

    }
}
