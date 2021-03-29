import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { ItemComponent } from '../components/item/item.component';
import { ItemEntity } from '../components/item/item-interface';
import { ItemToBE } from '../components/item/itemToBE-interface';

@Injectable({
  providedIn: 'root',
})
export class ItemsService {
  private readonly URL: string = 'http://localhost:8085/rest/api/BaseItem.svc/';

  constructor(private http: HttpClient) {}

  getItems(): Observable<ItemEntity[]> {
    console.log('Request is sent...');
    let items = this.http.get<ItemEntity[]>(`${this.URL}items`);
    return items;
  }

  // fetchItems(): ItemEntity[]{
  //   let items: ItemEntity[] = [
  //     {
  //       id: 0,
  //       name: 'NO DATA',
  //       price: 'NO DATA',
  //       property: 'NO DATA',
  //       sku: 'NO DATA',
  //       selected: false,
  //     },
  //   ];
  //   items = this.getItems().subscribe((data) => (items = data));
  // }

  saveItem(item: ItemToBE): Observable<any> {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(item);
    console.log(body);
    return this.http.post(this.URL + 'book', body, { headers: headers }).pipe(
      tap((_) => console.log(`update item id=${item.name}`)),
      catchError(this.handleError<any>('updateItem'))
    );
  }

  deleteItems(id: number): Observable<any> {
    return this.http.delete(`${this.URL}items/${id}`);
  }

  /*  * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
