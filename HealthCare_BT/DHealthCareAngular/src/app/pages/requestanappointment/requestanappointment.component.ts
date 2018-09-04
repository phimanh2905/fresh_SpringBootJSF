import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-requestanappointment',
  templateUrl: './requestanappointment.component.html',
  styleUrls: ['./requestanappointment.component.css']
})
export class RequestanappointmentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
//      ngAfterViewInit() {
//    // ...
//    setTimeout(() => {
//      this.loadScript();
//    }, -1000);
//
//  }
//  public loadScript() {
//    
//    let isFound = false;
//    const scripts = document.getElementsByTagName('script');
//    for (let i = 0; i < scripts.length; ++i) {
//        if (scripts[i].getAttribute('src') != null && scripts[i].getAttribute('src').includes('loader')) {
//            isFound = true;
//        }
//    }
//
//    if (/*!isFound*/ true ) {
//        var dynamicScripts = [
//          "assets/js/jquery-1.11.3.min.js",
//          "assets/js/dcalendar.picker.js",
//          "assets/js/dcalendar.init.js"
//        ];
//
//        for (var i = 0; i < dynamicScripts .length; i++) {
//            let node = document.createElement('script');
//            node.src = dynamicScripts [i];
//            node.type = 'text/javascript';
//            node.async = false;
//            node.charset = 'utf-8';
//            let body = <HTMLDivElement> document.body;
//            body.appendChild(node);
//        }
//
//    }
//  }

}
