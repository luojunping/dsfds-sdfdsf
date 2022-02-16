package com.ljp.util;

import java.util.UUID;

public final class TraceIdUtils {

    public static final String TRACE_ID = "traceId";

    public static String generateTraceId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
