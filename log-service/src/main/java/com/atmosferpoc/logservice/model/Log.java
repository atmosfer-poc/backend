package com.atmosferpoc.logservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "logs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private String message;
    private String level;
    private String timestamp;
}
