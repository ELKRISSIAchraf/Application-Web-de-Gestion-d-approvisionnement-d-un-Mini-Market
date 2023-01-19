import { Component } from '@angular/core';
import {NgbNavChangeEvent} from '@ng-bootstrap/ng-bootstrap';
import { FournisseurModule } from '../../models/fournisseur/fournisseur.module';
import { FournisseurService } from '../../services/fournisseur.service';
import * as $ from "jquery";

@Component({
  selector: 'app-ngbd-nav',
  templateUrl: './nav.component.html'
})
export class NgbdnavBasicComponent {

  fournisseurs:FournisseurModule[]=[] ;
  fournisseur=new FournisseurModule;
  tempId:any="";
  var:number=0;
  constructor(private fourSer:FournisseurService) { 
  }
  ngOnInit(): void {
    this.fourSer.getFormDb().subscribe(res=>{
      this.fournisseurs=res;
      console.log(res);
    })
   
  }
  search(input:any){
    this.fourSer.getFormDb();
  }
 
  add(){
    var message:any;

   this.fourSer.add(this.fournisseur).subscribe
     (res=>{
      this.fourSer.getFormDb().subscribe(res=>{
        this.fournisseurs=res;
        console.log(res);
      });
       alert("add with success");
     })

   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.fournisseurs.forEach(el=>{
      if(id==el.codeFour){
        $("#ucod").prop("value",el.codeFour)
        $("#unom").prop("value",el.nomFour)
        
        $("#utel").prop("value",el.telFour)
        $("#uville").prop("value",el.villeFour)
        
      }
    }
    )
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.fournisseur={
      codeFour:this.tempId,
      nomFour:$('#unom').val(),
      telFour:$('#utel').val(),
      villeFour:$('#uville').val(),
    }

    console.log(this.fournisseur);
    this.fourSer.update(this.fournisseur).subscribe
    (res=>{
      this.fourSer.getFormDb();
       alert("Update with success");
       this.fourSer.getFormDb().subscribe(res=>{
        this.fournisseurs=res;
        console.log(res);
      });
    })
     
   }
  selectForDelete(id:any){
    this.tempId=id;
    alert(id);
   
  }
  deleteConform(){
    this.fourSer.delete(this.tempId).subscribe
    (res=>{
      this.fourSer.getFormDb();
       alert("delete with success");
       this.fourSer.getFormDb().subscribe(res=>{
        this.fournisseurs=res;
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
