package com.petcareconnect.api.controller;

import com.petcareconnect.api.model.Community;
import com.petcareconnect.api.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/community")
public class CommunityController {
    private final ICommunityService communityService;

    @Autowired
    public CommunityController(ICommunityService communityService) {
        this.communityService = communityService;
    }

    @PostMapping("/create")
    public ResponseEntity<Community> createCommunity(@RequestBody Community community) {
        return new ResponseEntity<>(communityService.createCommunity(community), HttpStatus.CREATED);
    }
}
