package com.JuniorDevTestTask.mapping;

import com.JuniorDevTestTask.dto.BaseDto;
import com.JuniorDevTestTask.model.Item;
import com.JuniorDevTestTask.model.utils.BaseItem;
import org.springframework.stereotype.Component;

@Component
public class BaseMapper {

    public BaseDto toDto(Item item) {
        BaseDto baseDto = new BaseDto();
        baseDto.setId(item.getId());
        baseDto.setSku(item.getSku());
        baseDto.setName(item.getName());
        baseDto.setPrice(item.getPrice());
        return baseDto;
    }

    public Item fromDto(BaseDto baseDto) {
        Item item = new Item();
        item.setSku(baseDto.getSku());
        item.setName(baseDto.getName());
        item.setPrice(baseDto.getPrice());
        return item;
    }
}
