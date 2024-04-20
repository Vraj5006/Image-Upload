package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;
import com.example.demo.service.ImageService;

public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository imageRepository;

	@Override
	public void uploadImage(MultipartFile file) {
		try {
			Image image = new Image();
			image.setName(file.getOriginalFilename());
			image.setData(file.getBytes());
			imageRepository.save(image);
			System.out.println("Image saved successfully");
		} catch (Exception e) {
			System.out.println("Image is not uploaded");
		}
	}

	@Override
	public List<Image> get() {
		return imageRepository.findAll();
	}

}
