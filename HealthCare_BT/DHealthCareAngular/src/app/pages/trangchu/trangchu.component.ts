import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trangchu',
  templateUrl: './trangchu.component.html',
  styleUrls: ['./trangchu.component.css']
})
export class TrangchuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
    ngAfterViewInit() {
    // ...
    setTimeout(() => {
      this.loadScript();
    }, 5000);
    
  }
  public loadScript() {        
    var isFound = false;
    var scripts = document.getElementsByTagName("script")
    for (var i = 0; i < scripts.length; ++i) {
        if (scripts[i].getAttribute('src') != null && scripts[i].getAttribute('src').includes("loader")) {
            isFound = true;
        }
    }

    if (!isFound) {
//      alert(1)
        var dynamicScripts = ["assets/js/swiper.jquery.min.js"];

        for (var i = 0; i < dynamicScripts .length; i++) {
            let node = document.createElement('script');
            node.src = dynamicScripts [i];
            node.type = 'text/javascript';
            node.async = false;
//            node.charset = 'utf-8';
            let body = <HTMLDivElement> document.body;
            body.appendChild(node);
        }

    }
  }
}
