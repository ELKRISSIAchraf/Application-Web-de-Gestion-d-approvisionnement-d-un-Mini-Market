import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ArticleModule } from '../models/article/article.module';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  AllArticles= new Subject<ArticleModule[]>();

  private baseUrl="http://localhost:8084/article/";
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
  public getFormDb():Observable<ArticleModule[]> {
     this.http.get(this.baseUrl+"all").subscribe(res=>{
      var r:any=res;
      this.AllArticles.next(r.articles);

    });
      console.log(this.AllArticles);
      return    this.http.get<ArticleModule[]>(`${this.baseUrl}all`);

   
  }
}
