package org.smf.ensuaranceEx1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Shehan on 11/23/2015.
 */
@Service
public class QuoteSendService {

    private static final String SIMPLE_QUEUE = "simple.queue";

    private final JmsMessagingTemplate jmsMsgTemplate;

    @Autowired
    public QuoteSendService(JmsMessagingTemplate jmsTemplate) {

        this.jmsMsgTemplate = jmsTemplate;
    }

    public void setQuoteRequestOrder(Long userID , String desc) {
        jmsMsgTemplate.convertAndSend(SIMPLE_QUEUE,userID);

    }


}
