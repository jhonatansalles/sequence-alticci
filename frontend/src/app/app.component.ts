import {Component} from '@angular/core';
import {SequenceAlticciService} from "./services/sequenceAlticci.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app-sequence-alticci';
  index : any;
  alticciResult : any;

  constructor(private sequenceAlticciService: SequenceAlticciService) {
  }

  getAlticciSequence() {
    this.sequenceAlticciService.getAlticciSequence(this.index).subscribe(res => {
      this.alticciResult = res;
    });
  }
}
