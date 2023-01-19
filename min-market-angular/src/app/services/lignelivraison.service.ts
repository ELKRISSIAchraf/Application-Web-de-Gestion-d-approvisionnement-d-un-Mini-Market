import { Injectable } from '@angular/core';
import { LigneLivraisonModule } from '../models/lignelivraison/lignelivraison.module';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LignelivraisonService {
  AllLigneLivraisons= new Subject<LigneLivraisonModule[]>();

  private baseUrl="http://localhost:8084/ligneliv/";
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
  public getFormDb():Observable<LigneLivraisonModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllLigneLivraisons.next(r.socites);
      console.log(res);
    });
      console.log(this.AllLigneLivraisons);
      return    this.http.get<LigneLivraisonModule[]>(`${this.baseUrl}all`);

   
  }
}