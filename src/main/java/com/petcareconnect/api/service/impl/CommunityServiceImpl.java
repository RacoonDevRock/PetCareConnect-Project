package com.petcareconnect.api.service.impl;

import com.petcareconnect.api.model.Community;
import com.petcareconnect.api.repository.CommunityRepository;
import com.petcareconnect.api.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityServiceImpl implements ICommunityService {
    private final CommunityRepository communityRepository;

    @Autowired
    public CommunityServiceImpl(CommunityRepository communityRepository) {
        this.communityRepository = communityRepository;
    }

    @Override
    public Community createCommunity(Community community) {
        return communityRepository.save(community);
    }
}
