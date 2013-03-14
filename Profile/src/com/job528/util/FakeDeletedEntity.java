package com.job528.util;

 
public interface FakeDeletedEntity extends Entity {

    void setDeleted(boolean deleted);

    boolean isDeleted();

}
