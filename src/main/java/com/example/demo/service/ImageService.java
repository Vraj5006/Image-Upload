package com.example.demo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Image;

public interface ImageService {

	void uploadImage(MultipartFile file);
	
	List<Image> get();
}