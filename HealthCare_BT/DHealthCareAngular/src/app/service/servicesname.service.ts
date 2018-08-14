import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { SERVICE_ITEMS } from '../data/services.data';
import { ServiceName } from '../models/servicesname.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ServicesNameService {
//  private services = SERVICE_ITEMS;
//  services: ServiceName[];
  constructor(private http: HttpClient) {}
  
  private domain = 'http://192.188.88.119:8090';
  //==============================================
  
    public getAllServices() {
      return this.http.get<ServiceName[]>(this.domain + '/api/services');
  }
  //==============================================
  //  public getAllServices() {
//    const sv1 = new ServiceName('fa fa-user-md', 'Prescriptions', 'Treating some psychological disorders and some psychological issues may require a combination of both therapy and some medication...', '#');
//    const sv2 = new ServiceName('fa fa-stethoscope','Interventions','If you want to make a difference for one of your friend\'s or family member\'s life now, a professional intervention is the answer!', '#');
//    const sv3 = new ServiceName('fa fa-home','Family Therapy','With physical activity being a huge part of one\'s health and wellbeing, it can help you lose weight too!','#');
//    const sv4 = new ServiceName('fa fa-heart','Anxiety Therapy','With no one-fits-it-all diet program existing, we will custom-tailor a dieting program just for you!','#');
//    const sv5 = new ServiceName('fa fa-umbrella','Depression Therapy','Behind any overweight issue, there\'s a health problem that\'s hiding. We want to diagnose and treat it!','#');
//    const sv6 = new ServiceName('fa fa-user-plus','Personal Coaching','When it comes to weight loss treatments, children need an extra special attention given to them...','#');
//    const sv7 = new ServiceName('fa fa-plus-circle','Child Therapy','Just as it goes for juniors, seniors need a special approach when it comes to weight loss solutions.','#');
//    const sv8 = new ServiceName('fa fa-child','Psychotherapy','Bariatric (or stomach-related) surgeries are the last option for fixing excessive weight issue.','#');
//
//    this.services = [sv1, sv2, sv3, sv4, sv5, sv6, sv7, sv8];
//    return this.services;
//  }
 }


// crud
//getProductsFromData(): Product[] {
//    console.log(this.pItems);
//    return this.pItems
//  }
//
//  addProduct(product: Product) {
//    this.pItems.push(product);
//    console.log(this.pItems);
//  }
//
//  updateProduct(product: Product) {
//    let index = findIndex(this.pItems, (p: Product) => {
//      return p.id === product.id;
//    });
//    this.pItems[index] = product;
//  }
//
//  deleteProduct(product: Product) {
//    this.pItems.splice(this.pItems.indexOf(product), 1);
//    console.log(this.pItems);
//  }