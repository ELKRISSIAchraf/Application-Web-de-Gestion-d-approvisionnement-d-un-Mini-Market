import { Injectable } from '@angular/core';
import { LivraisonModule } from '../models/livraison/livraison.module';
import { Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LivraisonService {

  AllLivraisons= new Subject<LivraisonModule[]>();

  private baseUrl="http://localhost:8084/livraison/";
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
  public getFormDb():Observable<LivraisonModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllLivraisons.next(r.socites);
      console.log(res);
    });
      console.log(this.AllLivraisons);
      return    this.http.get<LivraisonModule[]>(`${this.baseUrl}all`);

   
  }
}