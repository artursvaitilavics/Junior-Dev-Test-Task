package com.JuniorDevTestTask.mapping;

import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.model.Dvd;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public ItemDto toDto(Book book) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(book.getId());
        itemDto.setSku(book.getSku());
        itemDto.setName(book.getName());
        itemDto.setPrice(book.getPrice());
        itemDto.setProperty(book.getProperty());
        return itemDto;
    }

    public Book fromDto(ItemDto itemDto) {
        Book book = new Book();
        book.setName(itemDto.getName());
        book.setPrice(itemDto.getPrice());
        book.setProperty(itemDto.getProperty());
        return book;
    }
}
