package hogwarts.workshop.util;


import static io.restassured.RestAssured.given;

public class Config {
    public String corpid = "xxx";
    public String corpsecret = "xxx";
    public Integer agentid = 1000002;
    public String access_token;



    static Config config;

    /**
     * sigle Config class
     */
    public static Config getInstance() {
        if (config == null) {
            config = new Config();
            config.access_token = config.getToken();
        }
        return config;
    }


    private String getToken() {
        return given()
                .log().all()
                .queryParam("corpid", Config.getInstance().corpid)
                .queryParam("corpsecret", Config.getInstance().corpsecret)
                .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("access_token");
    }
}
