import { Component } from "@angular/core";
import { SocieteModule } from "../../models/societe/societe.module";
import { SocieteService } from "../../services/societe.service";
import * as $ from "jquery";
import { FournisseurModule } from "../../models/fournisseur/fournisseur.module";
import { FournisseurService } from "../../services/fournisseur.service";
@Component({
  templateUrl: "badge.component.html",
})
export class BadgeComponent { 
  societes:SocieteModule[]=[] ;
  fournisseurs:FournisseurModule[]=[] ;

  societe=new SocieteModule;
  tempId="";
  nomFour="";
  var:number=0;

  constructor(private socSer:SocieteService,private forSer:FournisseurService) { }
  ngOnInit(): void {
    this.socSer.getFormDb().subscribe(res=>{
      this.societes=res;
      console.log(res);
    })
      this.forSer.getFormDb().subscribe(res=>{
        this.fournisseurs=res;
        
    })
   
  }

  search(input:any){
    this.socSer.getFormDb();
  }
 
  add(){
   /* var message:any;
    console.log(this.societe.codeFour);*/
   this.socSer.add(this.societe).subscribe
     (res=>{
      this.socSer.getFormDb().subscribe(res=>{
        this.societes=res;
        console.log(res);
      });
       alert("add with success");
     })
console.log(this.societe);
   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.societes.forEach(el=>{
      if(id==el.codeSte){
        $("#ucod").prop("value",el.codeSte)
        $("#unom").prop("value",el.nomSte)
        $("#ufax").prop("value",el.faxSte)
        $("#uville").prop("value",el.villeSte)
        $("#utel").prop("value",el.telSte)
        $("#ucodeFour").prop("value",el.fournisseur)
        
      }
    }
    )
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.societe={
      codeSte:this.tempId,
      nomSte:$('#unom').val(),
      telSte:$('#utel').val(),
      faxSte:$('#ufax').val(),
      fournisseur:{"codeFour": $('#fournisseur').val(),
      nomFour:"",
  villeFour:"",
  telFour:""},
      villeSte:$('#uville').val()
    }

    console.log(this.societe);
    this.socSer.update(this.societe).subscribe
    (res=>{
      this.socSer.getFormDb();
       alert("Update with success");
       this.socSer.getFormDb().subscribe(res=>{
        this.societes=res;
        console.log(res);
      });
    })
     
   }
  selectForDelete(id:any){
    this.tempId=id;
   console.log(id);
  }
  deleteConform(){
    this.socSer.delete(this.tempId).subscribe
    (res=>{
      this.socSer.getFormDb();
       alert("Update with success");
       this.socSer.getFormDb().subscribe(res=>{
        this.societes=res;
        console.log(res);
      });
    })
  }

  getFournisseur(id:any):any{
    this.fournisseurs.forEach(el=>{
      if(id==el.codeFour){
        this.nomFour=el.nomFour;
        return el.nomFour;
      }
    })
  }

  getIcon():any{
    if(this.var==0){ this.var=this.var+1;
    return "fa-regular fa-building";
  }
  if(this.var==1){ this.var=this.var+1;
  return "fa-solid fa-user-tie";
  }
  if(this.var==0){ this.var=0;
  return "fa-sharp fa-solid fa-building";
  }
  
  }
}