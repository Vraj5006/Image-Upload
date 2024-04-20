package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;
import com.example.demo.service.ImageService;

@Controller
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageService imageService;

	@PostMapping("/upload")
	public String uploadImage(@RequestPart MultipartFile file) {
		imageService.uploadImage(file);
		return "redirect:/";
	}
	
	@GetMapping("/get")
	public String getImage(Model model) {
		List<Image> image = imageService.get();
		model.addAttribute("images", image);
		return "index";
	}
}