import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { ItemComponent } from '../components/item/item.component';
import { ItemEntity } from '../components/item/item-interface';
import { ItemToBE } from '../components/item/itemToBE-interface';
import { ItemEdit } from '../components/item/item-edit';

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

  saveItem(item: ItemToBE): Observable<any> {
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(item);
    console.log(body);
    return this.http.post(this.URL + 'book', body, { headers: headers }).pipe(
      tap((_) => console.log(`update item id=${item.name}`)),
      catchError(this.handleError<any>('updateItem'))
    );
  }

  editItem(item: ItemEdit) {
    console.log('EDIT ITEM FROM SERVICES...');
    console.log('THIS IS WHAT IS RECEIVED FROM COMPONENT TO SERVICES:', item);
    const headers = { 'content-type': 'application/json' };
    const body = JSON.stringify(item);
    return this.http
      .put(this.URL + 'item/' + item.id, body, { headers: headers })
      .pipe(
        tap((_) => console.log(`update item id=${item.name}`)),
        catchError(this.handleError<any>('updateItem'))
      );
  }

  deleteItems(id: number): Observable<any> {
    return this.http.delete(`${this.URL}items/${id}`);
  }

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
