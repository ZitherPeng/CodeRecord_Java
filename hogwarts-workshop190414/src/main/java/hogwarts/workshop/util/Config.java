package hogwarts.workshop.util;


import static io.restassured.RestAssured.given;

public class Config {
    public String corpid = "ww768ab599d84d8428";
    public String corpsecret = "NlYG78ns8zK1ZPLlHI3f1Ir39Kqqh0xqCnTLbC9VU8E";
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
