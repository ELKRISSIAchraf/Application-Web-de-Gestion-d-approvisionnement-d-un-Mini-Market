import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CommandeModule } from '../models/commande/commande.module';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  AllCommandes= new Subject<CommandeModule[]>();

  private baseUrl="http://localhost:8084/commande/";
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
  public getFormDb():Observable<CommandeModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllCommandes.next(r.socites);
      console.log(res);
    });
      console.log(this.AllCommandes);
      return    this.http.get<CommandeModule[]>(`${this.baseUrl}all`);

   
  }
}