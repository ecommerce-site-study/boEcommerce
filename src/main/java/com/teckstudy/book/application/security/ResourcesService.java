package com.teckstudy.book.application.security;

import com.teckstudy.book.domain.resource.Resources;

import java.util.List;

public interface ResourcesService {

    Resources getResources(long id);

    List<Resources> getResources();

    void createResources(Resources Resources);

    void deleteResources(long id);
}