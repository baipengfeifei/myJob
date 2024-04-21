package com.easyjob.service;

import com.easyjob.dto.ImageCaptchaResult;

import java.io.IOException;

public interface ImageCaptchaService {

    ImageCaptchaResult generate() throws IOException;

    boolean verify(String key, String code);
}