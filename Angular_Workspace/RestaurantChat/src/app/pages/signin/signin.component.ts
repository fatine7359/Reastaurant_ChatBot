import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  signinForm : FormGroup;

  constructor(private authService : AuthenticationService, private fb : FormBuilder , private router : Router) { 
    this.signinForm = fb.group({
      email: '',
      password: ''
    });
  }

  ngOnInit(): void {
  }

  signIn(){
    this.authService.signIn(this.signinForm.get('email')?.value, this.signinForm.get('password')?.value);
  }

  goToSignup(){
    this.router.navigate(['signup']);
  }

}
