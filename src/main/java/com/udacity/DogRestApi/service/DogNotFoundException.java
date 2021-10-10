package com.udacity.DogRestApi.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "There is no such dog go and found a cat please :)")
public class DogNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String,Object> extentions = new HashMap<>();


    public DogNotFoundException(String message, Long InvalidId){


        super(message);

        extentions.put("Invalid Dog",InvalidId);
    }


    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extentions;
    }
}