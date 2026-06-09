package com.aivle.bookapp.services;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public String uploadBase64Image(String base64Image) {
        try {
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            Map uploadResult = cloudinary.uploader().upload(imageBytes, Map.of(
                    "folder", "book-covers",
                    "resource_type", "image"
            ));

            return uploadResult.get("secure_url").toString();

        } catch (Exception e) {
            throw new RuntimeException("Cloudinary 이미지 업로드 실패", e);
        }
    }
}