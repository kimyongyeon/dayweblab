//무엇을 해야하는지 정의 하는 곳

package com.hello.dev.hellospring.repository;

import java.util.List;

public interface CommonRepository<T> {

    void add(T entity);

    void update(T entity);

    void delete(T entity);

    List<T> listByStatus(String status);
}
