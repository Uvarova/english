package com.kids.english.service;

import netscape.security.ForbiddenTargetException;

public class StatusCodeFactory {
    public void exceptionFactory(int code) {
            switch (code) {
               /* case 400:
                    throw new UnauthorizedException();
                case 401:
                    throw new UnauthorizedException();*/
                case 404:
                    throw new ForbiddenTargetException();
               /* case 404:
                    throw new ForbiddenTargetException();
                case 405:
                    throw new ForbiddenTargetException();
                case 408:
                    throw new ForbiddenTargetException();
                case 500:
                    throw new ForbiddenTargetException();
                case 501:
                    throw new ForbiddenTargetException();
                case 502:
                    throw new ForbiddenTargetException();
                case 503:
                    throw new ForbiddenTargetException();*/
                default:
                    throw new ForbiddenTargetException();
            }
        }
}

