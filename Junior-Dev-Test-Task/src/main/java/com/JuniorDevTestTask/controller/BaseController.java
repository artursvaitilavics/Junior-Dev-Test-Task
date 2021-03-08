package com.JuniorDevTestTask.controller;

import com.JuniorDevTestTask.dto.BaseDto;
import com.JuniorDevTestTask.mapping.BaseMapper;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.model.utils.BaseItem;
import com.JuniorDevTestTask.service.BaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/api/BaseItem.svc")
@CrossOrigin("*")
public class BaseController {

    private final BaseService service;
    private final BaseMapper mapper;

    public BaseController(BaseService service, BaseMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/item")
    public BaseDto save(@RequestBody BaseDto baseDto) {
//        return mapper.toDto((service.save(mapper.fromDto(baseDto))));
        Item item = service.save(mapper.fromDto(baseDto));
        return mapper.toDto(item);

    }

    @GetMapping("/items")
    public List<BaseDto> getAll(){
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

}
