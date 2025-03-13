package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Optional;
import java.util.Map;

@Service
public class AIService {

    @Value("${openai.api.key}")
    private String openaiApiKey;

    private final BlogRepository blogRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public AIService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public String summarizeBlog(Long blogId) {
        Optional<Blog> blogOptional = blogRepository.findById(blogId);
        if (blogOptional.isEmpty()) {
            return "Blog not found!";
        }

        Blog blog = blogOptional.get();
        String blogContent = blog.getContent(); // Using your existing content field

        // OpenAI API request
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + openaiApiKey);

        String requestBody = """
        {
          "model": "gpt-3.5-turbo",
          "messages": [
              {"role": "system", "content": "Summarize the following blog post in a concise way."},
              {"role": "user", "content": "%s"}
          ],
          "max_tokens": 100
        }
        """.formatted(blogContent);

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Map> response = restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, Map.class);

        if (response.getBody() != null && response.getBody().containsKey("choices")) {
            Map<String, Object> choice = ((Map<String, Object>) ((java.util.List<?>) response.getBody().get("choices")).get(0));
            Map<String, Object> message = (Map<String, Object>) choice.get("message");
            return message.get("content").toString();
        } else {
            return "Failed to generate summary.";
        }
    }
}
