import { Component } from '@angular/core';
import { ClientModule } from '../../models/client/client.module';
import { clientService } from '../../services/client.service';
import {Product,TopSelling, TableRows, Employee} from './table-data';
import * as $ from "jquery";



@Component({
    selector: 'app-table',
    templateUrl: 'table.component.html'
})
export class TableComponent {
  
  clients:ClientModule[]=[] ;
  client=new ClientModule;
  tempId="";
  var:number=0;
  constructor(private cliSer:clientService) { 

 
  }
  ngOnInit(): void {
    this.cliSer.getFormDb().subscribe(res=>{
      this.clients=res;
      console.log(res);
    })
   
  }
  search(input:any){
    this.cliSer.getFormDb();
  }
 
  add(){
    var message:any;

   this.cliSer.add(this.client).subscribe
     (res=>{
      this.cliSer.getFormDb().subscribe(res=>{
        this.clients=res;
        console.log(res);
      });
       alert("add with success");
     })

   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.clients.forEach(el=>{
      if(id==el.codCli){
        $("#ucod").prop("value",el.codCli)
        $("#unom").prop("value",el.nomCli)
        $("#upre").prop("value",el.preCli)
        $("#uadr").prop("value",el.adrCli)
        $("#utel").prop("value",el.telCli)
        $("#uville").prop("value",el.villeCli)
        
      }
    }
    )
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.client={
      codCli:this.tempId,
      nomCli:$('#unom').val(),
      preCli:$('#upre').val(),
      telCli:$('#utel').val(),
      adrCli:$('#uadr').val(),
      villeCli:$('#uville').val(),
    }

    console.log(this.client);
    this.cliSer.update(this.client).subscribe
    (res=>{
      this.cliSer.getFormDb();
       alert("Update with success");
       this.cliSer.getFormDb().subscribe(res=>{
        this.clients=res;
        console.log(res);
      });
    })
     
   }
  selectForDelete(id:any){
    this.tempId=id;
   
  }
  deleteConform(){
    this.cliSer.delete(this.tempId).subscribe
    (res=>{
      this.cliSer.getFormDb();
       alert("Update with success");
       this.cliSer.getFormDb().subscribe(res=>{
        this.clients=res;
        console.log(res);
      });
    })
  }

  getIcon():any{
    if(this.var==0){ this.var=this.var+1;
    return "fa-solid fa-user";
  }
  if(this.var==1){ this.var=this.var+1;
  return "fa-solid fa-user-tie";
  }
  if(this.var==2){ this.var=this.var+1;
  return "fa-regular fa-user";
  }
  if(this.var==3){ this.var=0;
  return "fa-solid fa-user";
  }

  }

}
