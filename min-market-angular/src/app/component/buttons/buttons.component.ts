import { Component, OnInit } from "@angular/core";
import { LignecommandeService } from "../../services/lignecommande.service";
import { ClientModule } from "../../models/client/client.module";
import { CommandeModule } from "../../models/commande/commande.module";
import { clientService } from "../../services/client.service";
import { CommandeService } from "../../services/commande.service";
import { ArticleService } from "../../services/article.service";
import { LigneCommandeModule } from "../../models/lignecommande/lignecommande.module";
import { ArticleModule } from "../../models/article/article.module";
@Component({
  templateUrl: "buttons.component.html",
})
export class ButtonsComponent implements OnInit {
  //------------------------------------------Commande---------------------------------------------------
  commandes:CommandeModule[]=[] ;
  clients:ClientModule[]=[] ;

  commande=new CommandeModule;
  tempId="";
  static show:boolean=false;
  idSelected="";
  nomCli="";
  nomArt="";

  constructor(private artSer:ArticleService,private cliSer:clientService,private cmdSer:CommandeService,private lignecmdSer:LignecommandeService) { }   
  ngOnInit() {
    this.cmdSer.getFormDb().subscribe(res=>{
      this.commandes=res;
      console.log(res);
    })
      this.cliSer.getFormDb().subscribe(res=>{
        this.clients=res;  
    })
    this.lignecmdSer.getFormDb().subscribe(res=>{
      this.lignecommandes=res;
      console.log(res);
    })
    this.artSer.getFormDb().subscribe(res=>{
      this.articles=res;
      console.log(res);
    })
    
  }
  search(input:any){
    this.cmdSer.getFormDb();
  }
 
  add(){
   /* var message:any;
    console.log(this.cmdiete.codeFour);*/
   this.cmdSer.add(this.commande).subscribe
     (res=>{
      this.cmdSer.getFormDb().subscribe(res=>{
        this.commandes=res;
        console.log(res);
      });
       alert("add with success");
     })
console.log(this.commande);
   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.commandes.forEach(el=>{
      if(id==el.numCmd){
        $("#ucod").prop("value",el.numCmd)
        $("#unom").prop("value",el.dateCmd)
        $("#ucodeFour").prop("value",el.client)
      }

    }
    )
    
    alert("add with success");
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.commande={
      numCmd:this.tempId,
      dateCmd:$('#unom').val(),
      client:{"codCli": $('#fournisseur').val(),
      nomCli:" ",
  preCli:" ",
  adrCli:" ",
  telCli:" ",
  villeCli:" "},
    }

    console.log(this.commande);
    this.cmdSer.update(this.commande).subscribe
    (res=>{
      this.cmdSer.getFormDb();
       alert("Update with success");
       this.cmdSer.getFormDb().subscribe(res=>{
        this.commandes=res;
        console.log(res);
      });
    })
     
   }
  selectForDelete(id:any){
    this.tempId=id;
   console.log(id);
  }
  deleteConform(){
    this.cmdSer.delete(this.tempId).subscribe
    (res=>{
      this.cmdSer.getFormDb();
       alert("Update with success");
       this.cmdSer.getFormDb().subscribe(res=>{
        this.commandes=res;
        console.log(res);
      });
    })
  }
    getshow(){
      console.log("okftgyuioiuyt")
      this.idSelected="";
      return ButtonsComponent.show;
    }
  show(id:any){
    this.idSelected=id;
    if(!ButtonsComponent.show){
      ButtonsComponent.show=true;
    }else{
      ButtonsComponent.show=false;
    }
    this.tempId=id;
    this.lignescommandeById(this.tempId);
  }
//-----------------------------------LigneCommande----------------------------------------------
lignecommandes:LigneCommandeModule[]=[] ;
l:LigneCommandeModule[]=[] ;
articles:ArticleModule[]=[] ;
lignecommande=new LigneCommandeModule;
tempId_2="";
addLigne(){
  /* var message:any;
   console.log(this.cmdiete.codeFour);*/
   //this.lignecommande.Commande.numCmd=this.tempId;
  //alert(this.lignecommande.article)
  this.lignecommande.commande.numCmd=this.tempId;
 


  this.lignecmdSer.add(this.lignecommande).subscribe
    (res=>{
     this.lignecmdSer.getFormDb().subscribe(res=>{
       this.lignecommandes=res;
       console.log(res);
     });
      alert("add with success");
    })
console.log(this.lignecommande);
  
  }
  SelectForUpdate_2(id:any){
    this.tempId_2=id;
    this.lignecommandes.forEach(el=>{
      if(id==el.numLigne){
        $("#ucodL").prop("value",el.numLigne)
        $("#QteL").prop("value",el. qteCmd)
        $("#ucodeArc").prop("value",el.article)
       
        //------------------------
      }
    }
    )
  }
  update_2(){
    var message:any;
    
   const fd=new FormData();
    this.lignecommande={
      numLigne:this.tempId_2,
      qteCmd:$('#QteL').val(),
      article:{"codArt": $('#ucodeArc').val(),
      nomArt:" ",
      pu:" ",
      qteStock:" ",},
      commande:{
        "numCmd":this.tempId,
        dateCmd:" ",
        client:{  
        codCli:" ",
        nomCli:" ",
        preCli:" ",
        adrCli:" ",
        telCli:" ",
        villeCli:" ",
        }
      }

    }

    console.log(this.lignecommande);
    this.lignecmdSer.update(this.lignecommande).subscribe
    (res=>{
      this.lignecmdSer.getFormDb();
       alert("Update with success");
       this.lignecmdSer.getFormDb().subscribe(res=>{
        this.lignecommandes=res;
        console.log(res);
      });
    })
     
   }
   selectForDelete_2(id:any){
    this.tempId_2=id;
   console.log(id);
  }
  deleteConform_2(){
    this.lignecmdSer.delete(this.tempId_2).subscribe
    (res=>{
      this.lignecmdSer.getFormDb();
       alert("delete with success");
       this.lignecmdSer.getFormDb().subscribe(res=>{
        this.lignecommandes=res;
        console.log(res);
      });
    })
  }
  lignescommandeById(id:any){
    this.l=[];
    this.lignecommandes.forEach(el => {
      console.log(el.commande);
      if(id==el.commande){
       this.l.push(el);
      }
  });
  }

  getClient(id:any):any{
    this.clients.forEach(el=>{
      if(id==el.codCli){
        this.nomCli=el.nomCli;
        return el.nomCli;
      }
    })
  }
  getArticle(id:any):any{
    this.articles.forEach(el=>{
      if(id==el.codArt){
        this.nomArt=el.nomArt;
        return el.nomArt;
      }
    })
  }
  
}