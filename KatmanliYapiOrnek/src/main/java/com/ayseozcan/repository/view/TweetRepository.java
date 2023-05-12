package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Tweet;
import com.ayseozcan.utility.MyFactoryRepository;

public class TweetRepository extends MyFactoryRepository<Tweet,Long> {

    public TweetRepository() {
        super(new Tweet());
    }
}
