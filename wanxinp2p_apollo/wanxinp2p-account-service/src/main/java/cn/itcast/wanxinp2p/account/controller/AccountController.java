package cn.itcast.wanxinp2p.account.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "统一账户", tags = "account", description = "统一账户API")
public class AccountController {

    @ApiOperation("测试hello")
    @GetMapping(path = "/hello")
    public String hello() {
        return "hello====================";
    }

    @ApiOperation("测试hi")
    @PostMapping(path = "/hi")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String")
    public String hi(String name) {
        return "hi," + name;
    }

    @Test
  public void test(){
      System.out.println("1111111111");
  }
}
