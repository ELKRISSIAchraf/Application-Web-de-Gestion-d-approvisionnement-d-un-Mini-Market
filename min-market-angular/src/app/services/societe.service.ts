import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SocieteModule } from '../models/societe/societe.module';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SocieteService {
  AllSocietes= new Subject<SocieteModule[]>();

  private baseUrl="http://localhost:8084/societe/";
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
  public getFormDb():Observable<SocieteModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllSocietes.next(r.socites);
      console.log(res);

    });
      console.log(this.AllSocietes);
      return    this.http.get<SocieteModule[]>(`${this.baseUrl}all`);

   
  }
}
