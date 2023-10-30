//어떻게 작동할지 정의 하는곳
package com.hello.dev.hellospring.repository;

import com.hello.dev.hellospring.model.Todo;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemRepository implements CommonRepository<Todo> {
    private List<Todo> list = new ArrayList<>();

    @Override
    public void add(Todo todo) {
        list.add(todo);
    }

    @Override
    public void update(Todo todo) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().equals(todo.getTitle())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.set(index, todo);
        }
    }

    @Override
    public void delete(Todo todo) {
        list.remove(todo);
    }

    @Override
    public List<Todo> listByStatus(String status) {
        return list.stream()
                .filter(todo -> todo.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
