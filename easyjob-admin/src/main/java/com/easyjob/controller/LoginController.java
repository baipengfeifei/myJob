package com.easyjob.controller;

import com.easyjob.annotation.GlobalInterceptor;
import com.easyjob.entity.enums.ResponseCodeEnum;
import com.easyjob.entity.vo.ResponseVO;
import com.easyjob.exception.BusinessException;
import com.easyjob.service.SysAccountService;
import com.easyjob.utils.StringTools;
import com.easyjob.utils.VerifyCodeUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class LoginController extends ABaseController{
    @Resource
    private SysAccountService sysAccountService;
//    @Resource
//    private SysAccountStatusEnum sysAccountStatusEnum;
    @RequestMapping("/checkCode")
    @ResponseBody
    public void checkCode(HttpServletResponse httpServletResponse, HttpSession httpSession){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = VerifyCodeUtil.drawImage(output);
        //将验证码文本直接存放到session中
        httpSession.setAttribute("verifyCode", code);
        try {
            ServletOutputStream out = httpServletResponse.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @RequestMapping("/login")
    @GlobalInterceptor
    public ResponseVO login(HttpSession session, String phone, String password, String checkcode){
        if(StringTools.isEmpty(phone)||StringTools.isEmpty(password)|| StringTools.isEmpty(checkcode)){
            throw new BusinessException(ResponseCodeEnum.CODE_600);
        }
        if(!checkcode.equalsIgnoreCase((String) session.getAttribute("verifyCode"))){
            throw new BusinessException("eroor verifyCode!");
        }

        ResponseVO responseVO = sysAccountService.login(phone, password);
        return getSuccessResponseVO(null);

    }
}
