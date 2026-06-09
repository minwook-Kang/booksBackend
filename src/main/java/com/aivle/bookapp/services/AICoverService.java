package com.aivle.bookapp.services;

import com.aivle.bookapp.domain.AICoverRequest;
import com.aivle.bookapp.domain.AICoverResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AICoverService {

    private final RestClient restClient;
    private final CloudinaryService cloudinaryService;

    public AICoverResponse generateCover(AICoverRequest request) {

        String prompt = """
                다음 정보를 기반으로 전문적인 도서 표지를 제작해 주세요.

                Book title: %s
                Book Author: %s
                Book description: %s

                요구사항:
                - 도서의 핵심 내용과 분위기를 시각적으로 표현
                - 세련되고 현대적인 디자인
                - 과도한 텍스트 사용 금지
                - 워터마크, 로고, 광고 문구 금지
                - 고해상도 이미지
                - 출판용 표지 디자인 스타일
                """.formatted(request.getTitle(), request.getAuthor(), request.getContent());

        Map<String, Object> body = Map.of(
                "model", "gpt-image-2",
                "prompt", prompt,
                "size", "1024x1536",
                "quality", request.getQuality()
        );

        Map response = restClient.post()
                .uri("https://api.openai.com/v1/images/generations")
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + request.getApiKey())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body)
                .retrieve()
                .body(Map.class);

        List<Map<String, Object>> data =
                (List<Map<String, Object>>) response.get("data");

        String imageBase64 = (String) data.get(0).get("b64_json");

        String coverImageUrl = cloudinaryService.uploadBase64Image(imageBase64);

        return new AICoverResponse(coverImageUrl);
    }
}