package com.xiaoyi.springsecurity.utils;

/**
 * @author 王艺翔
 * @description MineJWT
 * @date 2022/10/11 20:02
 * @phone 18318436514
 * @email w2603494062@gmail.com
 * @github https://github.com/AGarden
 */
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/** 手写JWT */
public class MineJWT {

  public static void main(String[] args) {
    // 盐
    String jwtSecret = "xiaoyi";
    // Header(头部)
    JSONObject jwtHeader = new JSONObject();
    jwtHeader.put("alg", "HS256");
    jwtHeader.put("typ", "jwt");
    // Payload(有效载荷)
    JSONObject jwtPayload = new JSONObject();
    jwtPayload.put("userName", "xiaoyi01");
    jwtPayload.put("age", 22);
    // base64JwtHeader
    String base64JwtHeader =
        Base64.getEncoder().encodeToString(jwtHeader.toJSONString().getBytes());
    String base64JwtPayload =
        Base64.getEncoder().encodeToString(jwtPayload.toJSONString().getBytes());
    // Signature(签名)
    String signature = MD5Util.encode(jwtPayload.toJSONString() + jwtSecret);

    String jwt = base64JwtHeader + "." + base64JwtPayload + "." + signature;
    System.out.println(jwt);

    // 解密
    String jwtPayloadStr =
        new String(
            Base64.getDecoder().decode(jwt.split("\\.")[1].getBytes()), StandardCharsets.UTF_8);
    String jwtSignatureStr = jwt.split("\\.")[2];
    System.out.println(MD5Util.encode(jwtPayloadStr+jwtSecret).equals(jwtSignatureStr));
  }
}
