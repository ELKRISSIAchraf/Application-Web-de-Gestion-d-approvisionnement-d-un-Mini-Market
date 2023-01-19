import { Component } from '@angular/core';
import { ArticleModule } from '../../models/article/article.module';
import { ArticleService } from '../../services/article.service';
import * as $ from "jquery";
@Component({
  templateUrl: 'card.component.html'
})
export class CardsComponent {
  articles:ArticleModule[]=[] ;
  article=new ArticleModule;
  tempId="";
  var:number=0;

  constructor(private artSer:ArticleService) { 

    //this.topSelling=TopSelling;
   
    //this.trow=Employee;
  }
  ngOnInit(): void {
    this.artSer.getFormDb().subscribe(res=>{
      
      this.articles=res;
      console.log(res);
    })
   
  }
  search(input:any){
    this.artSer.getFormDb();
  }
 
  add(){

   this.artSer.add(this.article).subscribe
     (res=>{
      this.artSer.getFormDb().subscribe(res=>{
        this.articles=res;

        console.log(res);
      });
       alert("add with success");
     })

   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.articles.forEach(el=>{
      if(id==el.codArt){
        $("#ucod").prop("value",el.codArt)
        $("#unom").prop("value",el.nomArt)
        $("#upre").prop("value",el.pu)
        $("#uadr").prop("value",el.qteStock)
       
        
      }
    }
    )
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.article={
      codArt:this.tempId,
      nomArt:$('#unom').val(),
      pu:$('#upre').val(),
      qteStock:$('#uadr').val(),
     
    }

    console.log(this.article);
    this.artSer.update(this.article).subscribe
    (res=>{
      this.artSer.getFormDb();
       alert("Update with success");
       this.artSer.getFormDb().subscribe(res=>{
        this.articles=res;
        console.log(res);
      });
    })
     
   }
  selectForDelete(id:any){
    this.tempId=id;
   
  }
  deleteConform(){
    this.artSer.delete(this.tempId).subscribe
    (res=>{
      this.artSer.getFormDb();
       alert("Update with success");
       this.artSer.getFormDb().subscribe(res=>{
        this.articles=res;
        console.log(res);
      });
    })
  }
  getColor():any{
    if(this.var==0){ this.var=this.var+1;
    return "card bg-light-info";
  }
  if(this.var==1){ this.var=this.var+1;
  return "card bg-light-success";
  }
  if(this.var==2){ this.var=this.var+1;
  return "card bg-light-danger";
  }
  if(this.var==3){ this.var=0;
  return "card bg-light-primary";
  }

  }
}
