import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { LigneCommandeModule } from '../models/lignecommande/lignecommande.module';

@Injectable({
  providedIn: 'root'
})

export class LignecommandeService {

  AllLigneCommandes= new Subject<LigneCommandeModule[]>();

  private baseUrl="http://localhost:8084/lignecmd/";
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
  public getFormDb():Observable<LigneCommandeModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllLigneCommandes.next(r.socites);
      console.log(res);
    });
      console.log(this.AllLigneCommandes);
      return    this.http.get<LigneCommandeModule[]>(`${this.baseUrl}all`);

   
  }
}