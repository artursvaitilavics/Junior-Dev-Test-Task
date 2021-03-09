package com.JuniorDevTestTask.controller;

import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.mapping.BookMapper;
import com.JuniorDevTestTask.mapping.DvdMapper;
import com.JuniorDevTestTask.mapping.FurnitureMapper;
import com.JuniorDevTestTask.mapping.ItemMapper;
import com.JuniorDevTestTask.model.Book;
import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.model.Furniture;
import com.JuniorDevTestTask.service.BookService;
import com.JuniorDevTestTask.service.DvdService;
import com.JuniorDevTestTask.service.FurnitureService;
import com.JuniorDevTestTask.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/api/BaseItem.svc")
@CrossOrigin("*")
public class ItemController {

    private final ItemService service;
    private final DvdService dvdService;
    private final ItemMapper mapper;
    private final DvdMapper dvdMapper;
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final FurnitureMapper furnitureMapper;
    private final FurnitureService furnitureService;


    public ItemController(
            ItemService service,
            DvdService dvdService,
            ItemMapper mapper,
            DvdMapper dvdMapper,
            BookService bookService,
            BookMapper bookMapper,
            FurnitureMapper furnitureMapper,
            FurnitureService furnitureService) {
        this.service = service;
        this.dvdService = dvdService;
        this.mapper = mapper;
        this.dvdMapper = dvdMapper;
        this.bookService = bookService;
        this.bookMapper = bookMapper;
        this.furnitureMapper = furnitureMapper;
        this.furnitureService = furnitureService;
    }

    @PostMapping("/dvd")
    public ItemDto saveDvd(@Valid @RequestBody ItemDto itemDto) {
        Dvd item = dvdService.save(dvdMapper.fromDto(itemDto));
        return dvdMapper.toDto(item);
    }

    @PostMapping("/book")
    public ItemDto saveBook(@Valid @RequestBody ItemDto itemDto) {
        Book book = bookService.save(bookMapper.fromDto(itemDto));
        return bookMapper.toDto(book);
    }

    @PostMapping("/furniture")
    public ItemDto saveFurniture(@Valid @RequestBody ItemDto itemDto) {
        Furniture furniture = furnitureService.save(furnitureMapper.fromDto(itemDto));
        return furnitureMapper.toDto(furniture);
    }


    @GetMapping("/items")
    public List<ItemDto> getAll() {
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
