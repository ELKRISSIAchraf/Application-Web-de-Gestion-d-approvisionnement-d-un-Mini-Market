import { Component, OnInit } from '@angular/core';
import { CommandeModule } from '../../../models/commande/commande.module';
import { SocieteModule } from '../../../models/societe/societe.module';
import { ArticleService } from '../../../services/article.service';
import { clientService } from '../../../services/client.service';
import { CommandeService } from '../../../services/commande.service';
import { SocieteService } from '../../../services/societe.service';
import { ArticleModule } from '../../../models/article/article.module';
import { ClientModule } from '../../../models/client/client.module';


@Component({
  selector: 'app-top-cards',
  templateUrl: './top-cards.component.html'
})
export class TopCardsComponent implements OnInit {

  clients:ClientModule[]=[] ;
  articles:ArticleModule[]=[] ;
  societes:SocieteModule[]=[];
  commandes:CommandeModule[]=[];

  totArticles:number=0;
  totClients:number=0;
  totSocietes:number=0;
  totCommandes:number=0;


  constructor(private cliSer:clientService,private artSer:ArticleService,private socSer:SocieteService,private cmdSer:CommandeService) { }
  ngOnInit() {
    this.artSer.getFormDb().subscribe(res=>{
      this.articles=res;
      this.totArticles=0;
      this.articles.forEach(el => {
        this.totArticles+=1;
    });
    })
    this.cliSer.getFormDb().subscribe(res=>{
      this.clients=res;
      this.totClients=0;
      this.clients.forEach(el => {
        this.totClients+=1;
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
      this.commandes.forEach(el => {
        this.totCommandes+=1;
    });
    })
  }

}