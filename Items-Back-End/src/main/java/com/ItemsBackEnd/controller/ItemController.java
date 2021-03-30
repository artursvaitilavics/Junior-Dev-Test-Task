package com.ItemsBackEnd.controller;

import com.ItemsBackEnd.dto.ItemDto;
import com.ItemsBackEnd.mapping.BookMapper;
import com.ItemsBackEnd.mapping.DvdMapper;
import com.ItemsBackEnd.mapping.FurnitureMapper;
import com.ItemsBackEnd.mapping.ItemMapper;
import com.ItemsBackEnd.model.Book;
import com.ItemsBackEnd.model.Dvd;
import com.ItemsBackEnd.model.Furniture;
import com.ItemsBackEnd.model.Item;
import com.ItemsBackEnd.service.BookService;
import com.ItemsBackEnd.service.DvdService;
import com.ItemsBackEnd.service.FurnitureService;
import com.ItemsBackEnd.service.ItemService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/api/BaseItem.svc")
@CrossOrigin("*")
public class ItemController {

    private final ItemService itemService;
    private final DvdService dvdService;
    private final ItemMapper itemMapper;
    private final DvdMapper dvdMapper;
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final FurnitureMapper furnitureMapper;
    private final FurnitureService furnitureService;


    public ItemController(
            ItemService itemService,
            DvdService dvdService,
            ItemMapper itemMapper,
            DvdMapper dvdMapper,
            BookService bookService,
            BookMapper bookMapper,
            FurnitureMapper furnitureMapper,
            FurnitureService furnitureService) {
        this.itemService = itemService;
        this.dvdService = dvdService;
        this.itemMapper = itemMapper;
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

    @DeleteMapping("/items/{id}")
    public void deleteItems(@PathVariable("id") Long id) throws Exception {
        itemService.delete(id);

    }


    @GetMapping("/item/id")
    public ItemDto getById(@PathParam("id") Long id) throws Exception {
        return itemMapper.toDto(itemService.findById(id));
    }

    @GetMapping("/items")
    public List<ItemDto> getAll() {
        return itemService.findAll().stream().map(itemMapper::toDto).collect(Collectors.toList());
    }


    //    Change bellow to PUT
    @PutMapping("/item/{id}")
    public ItemDto update(@PathVariable("id") Long id, @RequestBody ItemDto itemDto) throws Exception {
        Item item = itemService.update(itemMapper.fromDto(itemDto), id);
        return itemMapper.toDto(item);
    }

}
