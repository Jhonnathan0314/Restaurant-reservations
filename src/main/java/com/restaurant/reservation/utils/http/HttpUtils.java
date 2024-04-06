package com.restaurant.reservation.utils.http;

import com.restaurant.reservation.utils.exceptions.InvalidBodyException;
import com.restaurant.reservation.utils.exceptions.NoChangesException;
import com.restaurant.reservation.utils.exceptions.NoResultsException;
import com.restaurant.reservation.utils.exceptions.NonExistenceException;
import org.springframework.http.HttpStatus;

public class HttpUtils {

    public HttpStatus determineHttpStatus(Exception e) {
        if (e instanceof InvalidBodyException) return HttpStatus.BAD_REQUEST;
        if (e instanceof NoChangesException) return HttpStatus.NOT_ACCEPTABLE;
        if (e instanceof NonExistenceException | e instanceof NoResultsException) return HttpStatus.NOT_FOUND;
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public int determineHttpErrorCode(Exception e) {
        if (e instanceof InvalidBodyException) return HttpStatus.BAD_REQUEST.value();
        if (e instanceof NoChangesException) return HttpStatus.NOT_ACCEPTABLE.value();
        if (e instanceof NonExistenceException | e instanceof NoResultsException) return HttpStatus.NOT_FOUND.value();
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public String determineHttpErrorMessage(Exception e) {
        if (e instanceof InvalidBodyException) return HttpStatus.BAD_REQUEST.name();
        if (e instanceof NoChangesException) return HttpStatus.NOT_ACCEPTABLE.name();
        if (e instanceof NonExistenceException | e instanceof NoResultsException) return HttpStatus.NOT_FOUND.name();
        return HttpStatus.INTERNAL_SERVER_ERROR.name();
    }

}
