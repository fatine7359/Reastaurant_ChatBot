import { Router } from '@angular/router';
import { AuthenticationService } from './../services/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signUpForm : FormGroup;

  constructor( private authService : AuthenticationService, private fb : FormBuilder , private router : Router) {
    this.signUpForm = fb.group({
      email: '',
      password: ''
    });
   }

  ngOnInit(): void {
  }

  signUp(){
    this.authService.SignUp(this.signUpForm.get('email')?.value, this.signUpForm.get('password')?.value);
  }

  goToSignin(){
    this.router.navigate(['signin']);
  }

}
