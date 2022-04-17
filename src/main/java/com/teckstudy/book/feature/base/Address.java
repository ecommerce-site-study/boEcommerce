package com.teckstudy.book.feature.base;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable {

    private String zipCode;

    private String address1;

    private String address2;

}
