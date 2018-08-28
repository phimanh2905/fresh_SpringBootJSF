import { Directive,Component, OnInit, Input } from '@angular/core';
//import '../../../assets/js/super_guacamole_min.js';
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
})

export class MenuComponent implements OnInit {
  loadAPI: Promise<any>;
  constructor() {
  this.loadAPI = new Promise((resolve) => {
        this.loadScript();
        resolve(true);
    });
}

  ngOnInit() {

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
        var dynamicScripts = ["assets/js/super_guacamole_min.js"];

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
