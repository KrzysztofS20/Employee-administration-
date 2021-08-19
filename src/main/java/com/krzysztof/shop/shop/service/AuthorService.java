package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.model.Author;
import com.krzysztof.shop.shop.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    public void editAuthor(Author author, Long id) {
        Author edited = new Author(
                id,
                author.getName(),
                author.getSurname()
        );
        saveAuthor(edited);
    }
}
