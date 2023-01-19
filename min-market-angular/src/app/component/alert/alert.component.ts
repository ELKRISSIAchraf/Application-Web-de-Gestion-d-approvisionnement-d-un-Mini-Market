import { Input, Component, OnInit } from '@angular/core';
import { ArticleModule } from '../../models/article/article.module';
import { LigneLivraisonModule } from '../../models/lignelivraison/lignelivraison.module';
import { FournisseurModule } from '../../models/fournisseur/fournisseur.module';
import { LivraisonModule } from '../../models/livraison/livraison.module';
import { FournisseurService } from '../../services/fournisseur.service';
import { LivraisonService } from '../../services/livraison.service';
import { LignelivraisonService } from '../../services/lignelivraison.service';
import { ArticleService } from '../../services/article.service';

@Component({
 
  templateUrl: 'alert.component.html',

})
export class NgbdAlertBasicComponent implements OnInit {
  livraisons:LivraisonModule[]=[] ;
  fournisseurs:FournisseurModule[]=[] ;

  livraison=new LivraisonModule;
  tempId="";
  static show:boolean=false;
  idSelected="";
  nomFour="";
  nomArt="";
  constructor(private artSer:ArticleService ,private fourSer:FournisseurService,private livSer:LivraisonService,private lignelivSer:LignelivraisonService) { }

  
  ngOnInit() {
    this.livSer.getFormDb().subscribe(res=>{
      this.livraisons=res;
      console.log(res);
    })
      this.fourSer.getFormDb().subscribe(res=>{
        this.fournisseurs=res;  
    })
   
  this.lignelivSer.getFormDb().subscribe(res=>{
    this.lignelivraisons=res;
    console.log(res);
  })
  this.artSer.getFormDb().subscribe(res=>{
    this.articles=res;
    console.log(res);
  })
  }

  search(input:any){
    this.livSer.getFormDb();
  }
 
  add(){
   /* var message:any;
    console.log(this.cmdiete.codeFour);*/
   this.livSer.add(this.livraison).subscribe
     (res=>{
      this.livSer.getFormDb().subscribe(res=>{
        this.livraisons=res;
        console.log(res);
      });
       alert("add with success");
     })
console.log(this.livraison);
   
   }
  SelectForUpdate(id:any){
    this.tempId=id;
    this.livraisons.forEach(el=>{
      if(id==el.numLiv){
        $("#ucod").prop("value",el.numLiv)
        $("#unom").prop("value",el.dateLiv)
        $("#ucodeFour").prop("value",el.fournisseur)
      }

    }
    )
  }
   update(){
    var message:any;
    
    const fd=new FormData();
    this.livraison={
      numLiv:this.tempId,
      dateLiv:$('#unom').val(),
      fournisseur:{"codeFour": $('#fournisseur').val(),
      nomFour:"",
  villeFour:"",
  telFour:""},
    }

    console.log(this.livraison);
    this.livSer.update(this.livraison).subscribe
    (res=>{
      this.livSer.getFormDb();
       alert("Update with success");
       this.livSer.getFormDb().subscribe(res=>{
        this.livraisons=res;
        console.log(res);
      });
    })
   }
  selectForDelete(id:any){
    this.tempId=id;
   console.log(id);
  }
  deleteConform(){
    this.livSer.delete(this.tempId).subscribe
    (res=>{
      this.livSer.getFormDb();
       alert("Update with success");
       this.livSer.getFormDb().subscribe(res=>{
        this.livraisons=res;
        console.log(res);
      });
    })
  }

  getshow(){
    console.log("okftgyuioiuyt")
    this.idSelected="";
    return NgbdAlertBasicComponent.show;
  }
show(id:any){
  this.idSelected=id;
  if(!NgbdAlertBasicComponent.show){
    NgbdAlertBasicComponent.show=true;
  }else{
    NgbdAlertBasicComponent.show=false;
  }
  this.tempId=id;
  this.lignescommandeById(this.tempId);
}

//-----------------------------------LigneCommande----------------------------------------------
lignelivraisons:LigneLivraisonModule[]=[] ;
l:LigneLivraisonModule[]=[] ;
articles:ArticleModule[]=[] ;
lignelivraison=new LigneLivraisonModule;
tempId_2="";
addLigne(){
  /* var message:any;
   console.log(this.cmdiete.codeFour);*/
   //this.lignecommande.Commande.numCmd=this.tempId;
  //alert(this.lignecommande.article)
  this.lignelivraison.livraison.numLiv=this.tempId;
 


  this.lignelivSer.add(this.lignelivraison).subscribe
    (res=>{
     this.lignelivSer.getFormDb().subscribe(res=>{
       this.lignelivraisons=res;
       console.log(res);
     });
      alert("add with success");
    })
console.log(this.lignelivraison);
  
  }
  SelectForUpdate_2(id:any){
    this.tempId_2=id;
    this.lignelivraisons.forEach(el=>{
      if(id==el.codeLigne){
        $("#ucodL").prop("value",el.codeLigne)
        $("#QteL").prop("value",el. qteLiv)
        $("#ucodeArc").prop("value",el.article)
       
        //------------------------
      }
    }
    )
  }
  update_2(){
    var message:any;
    
   const fd=new FormData();
    this.lignelivraison={
      codeLigne:this.tempId_2,
      qteLiv:$('#QteL').val(),
      article:{"codArt": $('#ucodeArc').val(),
      nomArt:" ",
      pu:" ",
      qteStock:" ",},
      livraison:{
        "numLiv":this.tempId,
        dateLiv:" ",
        fournisseur:{  
        codeFour:" ",
        nomFour:" ",
        telFour:" ",
        villeFour:" ",
        }
      }

    }

    console.log(this.lignelivraison);
    this.lignelivSer.update(this.lignelivraison).subscribe
    (res=>{
      this.lignelivSer.getFormDb();
       alert("Update with success");
       this.lignelivSer.getFormDb().subscribe(res=>{
        this.lignelivraisons=res;
        console.log(res);
      });
    })
     
   }
   selectForDelete_2(id:any){
    this.tempId_2=id;
   console.log(id);
  }
  deleteConform_2(){
    this.lignelivSer.delete(this.tempId_2).subscribe
    (res=>{
      this.lignelivSer.getFormDb();
       alert("delete with success");
       this.lignelivSer.getFormDb().subscribe(res=>{
        this.lignelivraisons=res;
        console.log(res);
      });
    })
  }
  lignescommandeById(id:any){
    this.l=[];
    this.lignelivraisons.forEach(el => {
      console.log(el.livraison);
      if(id==el.livraison){
       this.l.push(el);
      }
  });


  }

  getFournisseur(id:any):any{
    this.fournisseurs.forEach(el=>{
      if(id==el.codeFour){
        this.nomFour=el.nomFour;
        return el.nomFour;
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