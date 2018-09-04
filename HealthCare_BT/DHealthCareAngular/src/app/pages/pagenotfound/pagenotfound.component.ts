import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagenotfound',
  templateUrl: './pagenotfound.component.html',
  styleUrls: ['./pagenotfound.component.css']
})
export class PagenotfoundComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
      ngAfterViewInit() {
    // ...
    setTimeout(() => {
      this.loadScript();
    }, 1000);

  }
  public loadScript() {
    let isFound = false;
    const scripts = document.getElementsByTagName('script');
    for (let i = 0; i < scripts.length; ++i) {
        if (scripts[i].getAttribute('src') != null && scripts[i].getAttribute('src').includes('loader')) {
            isFound = true;
        }
    }

    if (/*!isFound*/ true ) {
        var dynamicScripts = [
          "assets/js/underscore.min.js",
          "assets/js/wp-util.min.js",
          "assets/js/cherry-search.min.js"
        ];

        for (var i = 0; i < dynamicScripts .length; i++) {
            let node = document.createElement('script');
            node.src = dynamicScripts [i];
            node.type = 'text/javascript';
            node.async = false;
            node.charset = 'utf-8';
            let body = <HTMLDivElement> document.body;
            body.appendChild(node);
        }

    }
  }

}
