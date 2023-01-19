import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { FournisseurModule } from '../models/fournisseur/fournisseur.module';

@Injectable({
  providedIn: 'root'
})

export class FournisseurService {
  AllFournissuers= new Subject<FournisseurModule[]>();

  private baseUrl="http://localhost:8084/fournisseur/";
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
  public getFormDb():Observable<FournisseurModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllFournissuers.next(r.fournisseurs);

    });
      console.log(this.AllFournissuers);
      return this.http.get<FournisseurModule[]>(`${this.baseUrl}all`);
  }
}
