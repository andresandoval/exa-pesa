import {Component} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {DashboardService} from "../dashboard.service";
import {Router} from "@angular/router";

@Component({
  selector: 'exp-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  constructor(private dashboardService: DashboardService, private router: Router) {
  }

  loginFormControl: FormControl = new FormControl('', [Validators.required]);
  passwordFormControl: FormControl = new FormControl('', [Validators.required]);

  public doLogin(): void {
    if (!this.loginFormControl.valid || !this.passwordFormControl.valid)
      return;
    let data = {
      username: this.loginFormControl.value,
      password: this.passwordFormControl.value
    };
    this.dashboardService.login(data);
  }

}
