import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

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
          
          "assets/js/cherry-js-core.min.js",
          "assets/js/spin.min.js",
          "assets/js/spin.jquery.js",
          "assets/js/jquery.tooltipster.min.js",
          "assets/js/functions.js",
          "assets/js/frontend-builder-global-functions.js",
          "assets/js/scripts.js",
          "assets/js/cherry-handler.min.js",
          "assets/js/cherry-post-formats.min.js",
          "assets/js/jquery.fitvids.js",
          "assets/js/waypoints.min.js",
          "assets/js/jquery.magnific-popup.min.js",
          "assets/js/jquery.mobile.custom.min.js",
          "assets/js/jquery.closest-descendent.js",
          "assets/js/jquery.reverse.js",
          "assets/js/jquery.tm-pb-simple-carousel.js",
          "assets/js/jquery.tm-pb-simple-slider.js",
          "assets/js/jquery.easypiechart.js",
          "assets/js/tm-hash.js",
          "assets/js/scripts(1).js",
          "assets/js/swiper.jquery.min.js",
          "assets/js/jquery.fittext.js",
          "assets/js/hoverIntent.min.js",
          "assets/js/super_guacamole_min.js",
          "assets/js/swiper(1).jquery.min.js",
          "assets/js/jquery.ui.totop.min.js",
          "assets/js/theme-script.js",
          "assets/js/wp-embed.min.js",
          "assets/js/cherry-services.js",
          "assets/js/public.min.js"

          
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
