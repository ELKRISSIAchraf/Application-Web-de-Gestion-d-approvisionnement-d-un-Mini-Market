import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { ClientModule } from '../models/client/client.module';

@Injectable({
  providedIn: 'root'
})
export class clientService {
  AllClients= new Subject<ClientModule[]>();

  private baseUrl="http://localhost:8084/client/";
  constructor(private http:HttpClient) { 
    this.getFormDb();
  }
  public add(form:any) {
    return this.http.post(this.baseUrl+"add",form);
  }
  public delete(id:any) {
    return this.http.delete(this.baseUrl+"delete/"+id);
  }
  public update(form:any) {
    return this.http.put(this.baseUrl+"update",form);
  }
  public getFormDb():Observable<ClientModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllClients.next(r.clients);

    });
      console.log(this.AllClients);
      return    this.http.get<ClientModule[]>(`${this.baseUrl}all`);

   
  }
}