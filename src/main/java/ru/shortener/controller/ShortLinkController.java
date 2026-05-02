package ru.shortener.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shortener.dto.ShortLinkResponse;
import ru.shortener.dto.ShortLinkStatsResponse;
import ru.shortener.dto.UrlRequest;
import ru.shortener.model.ShortLink;
import ru.shortener.config.AppProperties;
import ru.shortener.service.ShortLinkService;

@RestController
public class ShortLinkController {
    private final ShortLinkService service;
    private final AppProperties appProperties;

    ShortLinkController(AppProperties appProperties, ShortLinkService service) {
        this.service = service;
        this.appProperties = appProperties;
    }

    @GetMapping("/stats/{code}")
    public ShortLinkStatsResponse getStats(@PathVariable String code) {
        return service.getStats(code);
    }

    @PostMapping("/shorten")
    public ShortLinkResponse createShortLink(@RequestBody @Valid UrlRequest urlRequest) {
        String url = urlRequest.getUrl();
        ShortLink shortLink = service.createShortLink(url);
        String baseUrl = appProperties.getBaseurl();
        String clientUrl = baseUrl + "/" + shortLink.getShortcode();
        ShortLinkResponse clientUrlResponse = new ShortLinkResponse(clientUrl);
        return clientUrlResponse;
    }

    @GetMapping("/{code:[0-9A-Za-z]{9}}")
    public ResponseEntity<Void> getShortLink(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code);
        return ResponseEntity.status(307).header("Location", originalUrl).build();
    }
}
