package org.demon.dao;

import org.demon.domain.Book;

public interface BookDao {

    Book findById(Integer id);
}
