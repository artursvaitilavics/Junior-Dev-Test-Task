package com.ItemsBackEnd.controller;

import com.ItemsBackEnd.dto.SimpleDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple")
@CrossOrigin("*")
public class SimpleController {

    @GetMapping
    public SimpleDto getData() {
        SimpleDto dataDto = new SimpleDto();
        dataDto.setName("THI IS DATA_DTO SPARTAAAAAAAA!!!!!!!!");
        return dataDto;
    }
}
