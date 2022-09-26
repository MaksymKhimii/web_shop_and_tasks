package com.epam.khimii.task9.http.factory;

import java.net.URI;

public class QueryResponseFactory implements ResponseFactory {
    @Override
    public QueryProcessCreator createResponse(URI requestURI) {
        String path = requestURI.getPath();
        String query = requestURI.getQuery();
        if (path.equals("/shop/count")) {
            return new CountQuery();
        }
        if (path.contains("/shop/item") && query.contains("get_info=")) {
            return new GetProductQuery(query);
        }
        return new DefaultQuery();
    }
}