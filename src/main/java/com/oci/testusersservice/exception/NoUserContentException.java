package com.oci.testusersservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoUserContentException extends RuntimeException
{
}
