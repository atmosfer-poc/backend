package com.atmosferpoc.shared.config.properties.pojo;

import lombok.Data;

@Data
public class MailContentPojo {

    private String content;
    private String subject;
    private String contentFilePath;
}
