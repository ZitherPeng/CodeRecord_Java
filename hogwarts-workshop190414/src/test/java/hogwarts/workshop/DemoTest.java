package hogwarts.workshop;

import com.github.mustachejava.DefaultMustacheFactory;
import hogwarts.workshop.util.Message;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class DemoTest {

    @Test
    void getToken() {
        given()
                .log().all()
                .queryParam("corpid", "ww768ab599d84d8428")
                .queryParam("corpsecret", "NlYG78ns8zK1ZPLlHI3f1Ir39Kqqh0xqCnTLbC9VU8E")
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .statusCode(200)
                .body(containsString("ok"));
    }


    @Test
    void sendMessage() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", "1000002");
        HashMap<String, Object> content = new HashMap<String, Object>();
        content.put("content", "abc");
        data.put("text", content);
        data.put("safe", 0);


        given()
                .log().all()
                .queryParam("access_token", "EumWYSVCf1fTLhEnGV689QJLXrZuBR4FjrzxLtxRYcvXvAEtuygoif0oWKIb4u4rJn6nXYGRnyPA2q1wIQ0Xw2OeNcCicPDjo38eEipCTKeXZinPujqwP0fnbjht1HWwXYktmQFTLCNxMfNfjtDMWQN0orbAGzu5SKuCvv2jHk7Aa9RhS8-pA87ruwSFEFR5gZ81Md7XyuT8Xa64G0WbyQ")
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all()
                .statusCode(200);

    }


    @ParameterizedTest
    @ValueSource(strings = {
            "测试中文",
            "おはようございます",
            "<script>alert(77)</script>",
            "欢迎大家加入TesterHome技术Workshop <a href=\"https://testerhome.com\">TesterHomne社区论坛</a>" })
    @Test
    void sendMessage2(String msg) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", "1000002");
        HashMap<String, Object> content = new HashMap<String, Object>();
        content.put("content", msg);
        data.put("text", content);
        data.put("safe", 0);

        Message message = new Message();
        message.send(data).then().body("errcode", equalTo(0));

    }


    @Test
    void sendMessage3() {
        HashMap<String, Object> data = new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", "1000002");
        HashMap<String, Object> content = new HashMap<String, Object>();
        content.put("content", "你的快递已到");
        data.put("text", content);
        data.put("safe", 0);

        Message message = new Message();
        message.send(data).then().body("errcode", equalTo(0));

    }

    @Test
    void templand() throws IOException {
        Writer writer = new OutputStreamWriter(System.out);
        HashMap<String,Object> data = new HashMap<String, Object>();
        data.put("to","@all");
        data.put("msg","你的快递已到");
        new DefaultMustacheFactory().compile("data/message.json").execute(writer,data);
        writer.flush();
    }
}
