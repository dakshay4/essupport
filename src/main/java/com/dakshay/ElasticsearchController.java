package com.dakshay;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ElasticsearchController {

    private final ElasticServiceImpl elasticService;


    @GetMapping("/search")
    public ResponseEntity<Object> get(@RequestParam String query) {
        return ResponseEntity.ok(elasticService.search(query));
    }

}
