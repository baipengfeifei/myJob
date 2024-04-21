package com.easyjob.dto;

import lombok.Data;

@Data
public class ImageCaptchaResult {
    //图形验证码的key
    public String key;

    public String image;

    public String code;
}
