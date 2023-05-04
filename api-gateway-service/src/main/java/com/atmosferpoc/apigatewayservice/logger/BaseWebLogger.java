package com.atmosferpoc.apigatewayservice.logger;

import com.atmosferpoc.apigatewayservice.model.log.LogParameters;
import com.atmosferpoc.apigatewayservice.type.LogType;
import com.atmosferpoc.core.constant.HeaderNameConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.util.Pair;
import org.springframework.http.MediaType;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public abstract class BaseWebLogger {
    protected String body;
    protected Map<String, String> headers = new HashMap<>();

    protected BaseWebLogger() {
    }

    protected static final Set<String> LOGGABLE_CONTENT_TYPES = new HashSet<>(Arrays.asList(
            MediaType.APPLICATION_JSON_VALUE.toLowerCase(),
            MediaType.TEXT_PLAIN_VALUE.toLowerCase(),
            MediaType.TEXT_XML_VALUE.toLowerCase()
    ));

    public boolean isWritableContentType(MediaType mediaType) {
        return Objects.nonNull(mediaType) && LOGGABLE_CONTENT_TYPES.stream().anyMatch(ct -> ct.contains(mediaType.getType().toLowerCase()));
    }

    public void appendBody(ByteBuffer byteBuffer) {
        this.body = StandardCharsets.UTF_8.decode(byteBuffer).toString();
    }

    public abstract <T extends LogParameters> Pair<LogType, T> get();

    public String getTrxId() {
        return Objects.requireNonNullElse(headers.get(HeaderNameConstants.TRANSACTION_ID), "");
    }

    protected Long getUserId() {
        String userIdStr = headers.get(HeaderNameConstants.AUTHENTICATED_USER_ID);

        return StringUtils.isNotBlank(userIdStr) ? Long.parseLong(userIdStr) : 0L;
    }
}
