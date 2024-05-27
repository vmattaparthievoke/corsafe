package com.nti.corsafe.site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {
    @Autowired
    private SiteRepository siteRepository;

}
