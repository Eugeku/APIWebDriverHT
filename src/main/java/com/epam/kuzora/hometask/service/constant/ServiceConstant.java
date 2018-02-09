package com.epam.kuzora.hometask.service.constant;

public class ServiceConstant {
    public interface Validation {
        String JSON_V4_SCHEMA_IDENTIFIER = "http://json-schema.org/draft-06/schema#";
        String JSON_SCHEMA_IDENTIFIER_ELEMENT = "$schema";
    }

    public interface LogMessages {
        String PARSE_JSON_INTO_LIST = "Parse json into list of %s objects\n\r";
        String PARSE_LIST_INTO_JSON = "Parse list of %s objects into json\n\r";
        String PARSE_JSON_INTO_OBJECT = "Parse json into object of %s\n\r";
        String PARSE_OBJECT_INTO_JSON = "Parse object of %s into json\n\r";
    }
}
