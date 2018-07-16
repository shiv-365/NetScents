import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  tab1Root: any = 'Home';
  tab2Root: any = 'Active Connections'
  tab3Root: any = 'History';
  tab4Root: any = 'Notes';
  tab5Root: any = 'Settings';



  constructor(public navCtrl: NavController) {

  }

}
