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

    @DeleteMapping("/items")
    public void deleteItems(@RequestBody List<ItemDto> itemDtos) throws Exception {
        itemDtos.forEach(itemDto -> {
            try {
                itemService.delete(itemDto.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        itemService.delete(itemDto.getId());

    }


    @GetMapping("/items")
    public List<ItemDto> getAll() {
        return itemService.findAll().stream().map(itemMapper::toDto).collect(Collectors.toList());
    }

}
