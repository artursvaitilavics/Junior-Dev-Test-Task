import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { ItemEntity } from '../item/item-interface';
import { ItemComponent } from '../item/item.component';

import { ItemsService } from '../../services/items.service';
import { ItemToBE } from '../item/itemToBE-interface';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.css'],
})
export class ItemsComponent implements OnInit {
  items: ItemEntity[] = [
    {
      id: 0,
      name: 'NO DATA',
      price: 'NO DATA',
      property: 'NO DATA',
      sku: 'NO DATA',
      selected: false,
    },
  ];

  selectedItems: ItemEntity[] = [];

  @Input()
  item: ItemToBE = {
    name: 'TEMP NAME',
    price: 'TEMP PRICE',
    property: 'TEMP PROP',
  };

  constructor(private itemsService: ItemsService) {
    this.refreshItems();
    // this.itemsService.getItems().subscribe((items) => (this.items = items));
    // this.itemsService.getItems();
  }

  ngOnInit(): void {}

  saveItem() {
    this.itemsService.saveItem(this.item).subscribe((data) => {
      this.items = data;
    });

    this.refreshItems();
    this.clearItem();
  }

  refreshItems() {
    console.log('Loading items from back-end...');
    setTimeout(() => {
      this.itemsService.getItems().subscribe((items) => (this.items = items));
    }, 1000);

    // this.itemsService.getItems();
  }

  clearItem() {
    this.item.name = 'TEMP NAME';
    this.item.price = 'TEMP PRICE';
    this.item.property = 'TEMP PROP';
  }

  deleteItems() {
    console.log('deleteItems()');
    const itemsToDelete = this.getSelected(this.items);

    itemsToDelete.forEach((item) =>
      this.itemsService.deleteItems(item.id).subscribe()
    );

    console.log(itemsToDelete);

    this.refreshItems();

    // this.service.deletePost(post.id)
    // .subscribe(response => {
    //   this.posts = this.posts.filter(item => item.id !== post.id);
    // });
  }

  clearSelection(items: ItemEntity[]) {
    items.forEach((item) => (item.selected = false));
    this.refreshItems();
  }

  getSelected(items: ItemEntity[]): ItemEntity[] {
    return items.filter((item) => item.selected);
  }
}
