package com.mly.mango.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.mly.mango.admin.model.LoginBean;
import com.mly.mango.admin.model.SysUser;
import com.mly.mango.admin.service.SysUserService;
import com.mly.mango.admin.utils.JwtAuthenticatioToken;
import com.mly.mango.admin.utils.PasswordUtils;
import com.mly.mango.admin.utils.SecurityUtils;
import com.mly.mango.core.http.HttpResult;
import com.mly.mango.utils.IOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wyn
 * @Description 登录控制器
 * @date 2020-04-05 23:08
 */
@RestController
@Api(tags = "登录模块")
public class SysLoginController {



    @Autowired
    private Producer producer;



    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    @ApiOperation("登陆接口")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request)
    throws IOException{

        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        //从session中获取之前保存的验证码，跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY);

        if(kaptcha==null){
            return HttpResult.error("验证码已失效");
        }

        if(!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }


        SysUser sysUser = sysUserService.findByName(username);
        if(sysUser ==null){
            return HttpResult.error("账号不存在");
        }
        if(!PasswordUtils.matches(sysUser.getSalt(),password,sysUser.getPassword())){
           return HttpResult.error("密码不正确");
        }

        //账号锁定
        if(sysUser.getStatus() ==0){
            return HttpResult.error("账号已被锁定，请联系管理员");
        }

        JwtAuthenticatioToken token = SecurityUtils.login(request,username,password,authenticationManager);

        return HttpResult.ok(token);
    }


    /**
     * 图片验证
     * @param response
     * @param request
     */
    @GetMapping("/captcha.jpg")
    @ApiOperation("图片验证码")
    public void captcha(HttpServletResponse response, HttpServletRequest request)
    throws ServletException, IOException {

        response.setHeader("Cache-Control","no-store,no-cache");
        response.setContentType("image/jpeg");
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到验证码到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_CONFIG_KEY,text);
        ServletOutputStream outputStream = response.getOutputStream();

        ImageIO.write(image,"jpg",outputStream);

        IOUtils.closeQuietly(outputStream);

    }
}
