package model.repository;

import java.util.List;

public interface ITagRepo<E> {
    List<E> selectAll();
}
