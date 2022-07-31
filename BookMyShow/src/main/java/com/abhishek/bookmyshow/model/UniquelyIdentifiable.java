package com.abhishek.bookmyshow.model;

import java.io.Serializable;

public interface UniquelyIdentifiable extends Serializable {
    Long getId();
    void setId(Long id);
}