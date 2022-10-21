package com.whoisacat.edu.coursework.bookSharingProvider.service;

import com.whoisacat.edu.coursework.bookSharingProvider.domain.Titled;

import java.util.List;

public interface NamedService<T extends Titled>{

    default String buildNames(List<T> objects){
        StringBuilder builder = new StringBuilder();
        for(T object : objects){
            builder.append(object.getTitle())
                    .append(';')
                    .append(' ');
        }
        return builder.toString();
    }

}
