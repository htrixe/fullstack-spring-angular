package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.model.Image;

@Controller
public class ImageController {

	@RequestMapping(value = "/user/getImagesList", produces = "application/json")
	@ResponseBody
	public List<Image> getEmployeesList() {
		List<Image> images = new ArrayList<>();

		Image img1 = new Image();
		img1.setImgId("1353");
		img1.setImgName("Image 1");

		Image img2 = new Image();
		img2.setImgId("1752");
		img2.setImgName("Image 2");

		images.add(img1);
		images.add(img2);

		return images;

	}

}