package com.sulai.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EmptyObject {

    private final static EmptyObject EMPTY_OBJECT = new EmptyObject();
    /**
     * <p>Constructor for EmptyObject.</p>
     */
    public EmptyObject(){
    }

    /**
     * <p>get.</p>
     *
     * @param <T> a T object.
     * @return a T object.
     */
    public static <T> T get(){
        return (T) EMPTY_OBJECT;
    }
}
