package com.JuniorDevTestTask.controller;

import com.JuniorDevTestTask.dto.ItemDto;
import com.JuniorDevTestTask.mapping.DvdMapper;
import com.JuniorDevTestTask.mapping.ItemMapper;
import com.JuniorDevTestTask.model.Dvd;
import com.JuniorDevTestTask.service.DvdService;
import com.JuniorDevTestTask.service.ItemService;
import org.springframework.web.bind.annotation.*;

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

    public ItemController(ItemService service, DvdService dvdService, ItemMapper mapper, DvdMapper dvdMapper) {
        this.service = service;
        this.dvdService = dvdService;
        this.mapper = mapper;
        this.dvdMapper = dvdMapper;
    }

    @PostMapping("/dvd")
    public ItemDto saveDvd(@RequestBody ItemDto itemDto) {
        Dvd item = dvdService.save(dvdMapper.fromDto(itemDto));
        return dvdMapper.toDto(item);
    }



    @GetMapping("/items")
    public List<ItemDto> getAll(){
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
