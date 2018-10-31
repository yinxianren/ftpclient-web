package com.bjsxt.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.bjsxt.service.UploadService;

@Controller
public class UploadController {
	@Resource
	private UploadService uploadService;
	@RequestMapping("upload")
	public String upload(MultipartFile file) {
		try {
			boolean result = uploadService.upload(file);
			if(result){
				return "/success.jsp";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/error.jsp";
	}
}
