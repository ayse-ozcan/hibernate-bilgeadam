package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Tweet;
import com.ayseozcan.repository.view.TweetRepository;
import com.ayseozcan.utility.MyFactoryService;

public class TweetService extends MyFactoryService<Tweet,TweetRepository> {

    public TweetService(){
        super(new TweetRepository());
    }
}

