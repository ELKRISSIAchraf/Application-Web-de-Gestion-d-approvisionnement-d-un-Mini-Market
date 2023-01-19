import { ArticleModule } from "../article/article.module";
import { CommandeModule } from "../commande/commande.module";

export class LigneCommandeModule { 
  numLigne:any="";
  qteCmd:any="";
  article:ArticleModule={  
  codArt:"",
  nomArt:"",
  pu:"",
  qteStock:"",
  }
  commande:CommandeModule={  
    numCmd:" ",
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