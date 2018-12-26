import { Component, OnInit } from '@angular/core';
import { InterfaceService } from 'src/app/interface/interface.component';
@Component({
    selector: 'storeFooter',
    templateUrl: 'footer.component.html',
    styleUrls:['footer.component.css']
})

export class FooterComponent implements OnInit {
    private list:any;
    constructor(private service:InterfaceService) { 
        var that=this;
        this.service.interface("SysUserInfo/getMenu.do",null,
            function(data:any){
                that.list=data;
            }
        )
    }

    ngOnInit() { }
}