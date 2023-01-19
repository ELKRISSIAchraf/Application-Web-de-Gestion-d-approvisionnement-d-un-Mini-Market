import { ArticleModule } from "../article/article.module";
import { CommandeModule } from "../commande/commande.module";
import { FournisseurModule } from "../fournisseur/fournisseur.module";
import { LivraisonModule } from "../livraison/livraison.module";

export class LigneLivraisonModule { 
  codeLigne:any="";
  qteLiv:any="";
  article:ArticleModule={  
  codArt:" ",
  nomArt:" ",
  pu:" ",
  qteStock:" ",
  }
  livraison:LivraisonModule={  
  numLiv:" ",
  dateLiv:" ",
  fournisseur:{  
    codeFour:" ",
    nomFour:"",
    villeFour:"",
    telFour:""
  }
  }
}