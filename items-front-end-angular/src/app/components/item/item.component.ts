import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { ItemEntity } from './item-interface';
import { ItemsService } from '../../services/items.service';
import { ItemEdit } from '../item/item-edit';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})

// Option to select:
//      set selected true -> change color to selected -> copy id, name priceperty and sku in a itemsEntity list
//      button Delete ->  sends list to sevices -> sends list to back end for delete
//      button Cancel -> reset color to unselected -> clear list
//
export class ItemComponent implements OnInit {
  @Input() item: ItemEntity = {
    id: 0,
    name: '',
    price: '',
    property: '',
    sku: '',
    selected: false,
  };

  hover: boolean = false;
  selected: boolean = false;
  dataVisible: boolean = true;

  hoverColor: string = '#7fffd4';
  defaultColor: string = '#00ffff';
  selectedColor: string = '#ff0000';

  constructor(
    private itemsService: ItemsService,
    private formBuilder: FormBuilder
  ) {}

  editForm = this.formBuilder.group({
    id: 0,
    name: '',
    price: '',
    property: '',
    sku: '',
  });

  ngOnInit(): void {}

  toggleEdit() {
    this.dataVisible = !this.dataVisible;
  }

  edit(): void {
    console.log(this.editForm.value);
    this.itemsService.editItem(this.editForm.value);
    this.toggleEdit();
  }

  selectItem() {
    this.item.selected = true;
    this.defaultColor = this.selectedColor;
    console.log(this.item.name);
    console.log(this.selected);
  }
}
