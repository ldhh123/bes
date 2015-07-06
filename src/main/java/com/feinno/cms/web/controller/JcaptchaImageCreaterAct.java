package com.feinno.cms.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
@RequestMapping("/bs")
public class JcaptchaImageCreaterAct  {
	Logger logger=Logger.getLogger(JcaptchaImageCreaterAct.class);
	@Autowired  
	@Qualifier("imageCaptchaService")
    private ImageCaptchaService imageCaptchaService;
	@RequestMapping(value="/captcha")
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {  
        try {  
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();  
            String captchaId = request.getSession().getId();  
            BufferedImage challenge = imageCaptchaService.getImageChallengeForID(captchaId, request.getLocale());  
  
            response.setHeader("Cache-Control", "no-store");  
            response.setHeader("Pragma", "no-cache");  
            response.setDateHeader("Expires", 0L);  
            response.setContentType("image/jpeg");  
            ImageIO.write(challenge, "jpeg", jpegOutputStream);  
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();  
  
            ServletOutputStream respOs = response.getOutputStream();  
            respOs.write(captchaChallengeAsJpeg);  
            respOs.flush();
            respOs.close();
        } catch (IOException e) {  
            logger.error("验证码生成失败",e);  
        }  
    }  
}
