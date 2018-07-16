import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

/**
 * Generated class for the ActivePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-active',
  templateUrl: 'active.html',
})
export class ActiveConnections {

  connections: any;

  constructor(public navCtrl: NavController, public navParams: NavParams) {
  

  this.connections = [
    'Device 1',
    'Device 2'

  ];
  }

}
