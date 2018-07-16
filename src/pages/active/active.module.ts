import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ActiveConnections } from './active';

@NgModule({
  declarations: [
    ActiveConnections,
  ],
  imports: [
    IonicPageModule.forChild(ActiveConnections),
  ],
})
export class ActivePageModule {}
