package com.atmosferpoc.accountservice.service.impl;

import com.atmosferpoc.accountservice.service.EulaService;
import com.atmosferpoc.shared.model.resource.EulaResource;
import org.springframework.stereotype.Service;

@Service
public class EulaServiceImpl implements EulaService {
    @Override
    public EulaResource get() {
        return new EulaResource("<html><h1>Aydınlatma Metni</h1></html>");
    }
}
