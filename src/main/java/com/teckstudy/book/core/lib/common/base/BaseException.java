package com.teckstudy.book.core.lib.common.base;

/**
 * <pre>
 * com.teckstudy.book.core.lib.common.fuction.exception
 *      BaseException
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-17 오후 11:34
 */


public interface BaseException<T> {
    T throwException();
}
