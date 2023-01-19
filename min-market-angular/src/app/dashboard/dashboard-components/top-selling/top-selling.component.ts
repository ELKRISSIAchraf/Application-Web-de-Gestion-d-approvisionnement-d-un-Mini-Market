import { Component, OnInit } from '@angular/core';
import {Product,TopSelling} from './top-selling-data';
import { CommandeModule } from '../../../models/commande/commande.module';
import { SocieteModule } from '../../../models/societe/societe.module';
import { ArticleService } from '../../../services/article.service';
import { clientService } from '../../../services/client.service';
import { CommandeService } from '../../../services/commande.service';
import { SocieteService } from '../../../services/societe.service';
import { ArticleModule } from '../../../models/article/article.module';
import { ClientModule } from '../../../models/client/client.module';

@Component({
  selector: 'app-top-selling',
  templateUrl: './top-selling.component.html'
})
export class TopSellingComponent implements OnInit {

  clients:ClientModule[]=[] ;
  articles:ArticleModule[]=[] ;
  societes:SocieteModule[]=[];
  commandes:CommandeModule[]=[];

  totArticles:number=0;
  totClients:number=0;
  totSocietes:number=0;
  totCommandes:number=0;
  var:number=0;
  clientsrecentlyadded: ClientModule[]=[] ;
  clientsrecentlyaddedTrier: ClientModule[]=[] ;
 articlesrecentlyadded: ArticleModule[]=[] ;
  articlesrecentlyaddedTrier: ArticleModule[]=[] ;
  constructor(private cliSer:clientService,private artSer:ArticleService,private socSer:SocieteService,private cmdSer:CommandeService) { }
  ngOnInit() {
    this.artSer.getFormDb().subscribe(res=>{
      this.articles=res;
      this.totArticles=0;
      this.articlesrecentlyadded=this.articles.reverse();
      this.articles.forEach(el => {
        this.totArticles+=1;
    });
    var i:number=0;
    this.articlesrecentlyadded.forEach(el => {
     if (i<4) {
      this.articlesrecentlyaddedTrier.push(el);
      i+=1;
     }
  });
    })
    this.cliSer.getFormDb().subscribe(res=>{
      this.clients=res;
      this.totClients=0;
      this.clientsrecentlyadded=this.clients.reverse();
      this.clients.forEach(el => {
        this.totClients+=1;
    });
    var i:number=0;
    this.clientsrecentlyadded.forEach(el => {
     if (i<4) {
      this.clientsrecentlyaddedTrier.push(el);
      i+=1;
     }
  });
    })
    this.socSer.getFormDb().subscribe(res=>{
      this.societes=res;
      this.totSocietes=0;
      this.societes.forEach(el => {
        this.totSocietes+=1;
    });
    })
    this.cmdSer.getFormDb().subscribe(res=>{
      this.commandes=res;
      this.totCommandes=0;
      this.societes.forEach(el => {
        this.totCommandes+=1;
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