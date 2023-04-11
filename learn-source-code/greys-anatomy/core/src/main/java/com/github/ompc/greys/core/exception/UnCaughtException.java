package com.github.ompc.greys.core.exception;

/**
 * 未捕获异常<br/>
 * 用来封装不希望抛出的异常
 * Created by vlinux on 16/5/21.
 */
public class UnCaughtException extends RuntimeException {

    public UnCaughtException(Throwable cause) {
        super(cause);
    }
}
