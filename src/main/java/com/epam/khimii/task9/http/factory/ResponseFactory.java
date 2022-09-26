package com.epam.khimii.task9.http.factory;

import java.net.URI;

public interface ResponseFactory {
    QueryProcessCreator createResponse(URI requestURI);
}