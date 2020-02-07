import { Component, ViewChild } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  user_pass:any;
  user_name:any;
  user_money:Number;
  modelATM:ATM;
  displayVaild=false;
  displayResult=null;
  constructor(private http:HttpClient){}
  ngOnInit(){
    
  }
  onClick(){
    let model ={
      user_pass:this.user_pass,
      user_name:this.user_name
      
    }
    this.vaildPass(model).subscribe(data =>{
        console.log(data,this.user_name,this.user_pass)
        this.displayVaild=data;
        this.user_name=""
        
       });
  }
  clickDeposit(){
    let model = {
      user_pass : this.user_pass,
      user_money:this.user_money
    }
    this.deposit(model).subscribe(data =>{
      console.log(data)
      this.displayResult=data;
      this.user_name="";
      this.user_money=null;
     });
  }
  clickWithdraw(){
    let model = {
      user_pass : this.user_pass,
      user_money:this.user_money
    }
    this.withdraw(model).subscribe(data =>{
      console.log(data)
      this.displayResult=data;
      this.user_name="";
      this.user_money=null;
     });
  }
  clickTransfer(){
    let model = {
      user_id:0,
      user_pass : this.user_pass,
      user_money:this.user_money,
      user_name:this.user_name
    }
    this.transfer(model).subscribe(data =>{
      console.log(data)
      this.displayResult=data;
      this.user_name="";
      this.user_money=null;
     });
  }
  clickCheckMoney(){
    this.checkMoney(this.user_pass).subscribe(data =>{
      console.log(data)
      this.modelATM=data;
     });
  }

  //ติดต่อกับหลังบ้าน
      vaildPass(user_pass):Observable<any>{
          return this.http.post('localhost:4200/atm/checkAccount',user_pass)
        }
      deposit(model):Observable<any>{
          return this.http.post('localhost:4200/atm/deposit',model)
        }
      withdraw(model):Observable<any>{
          return this.http.post('localhost:4200/atm/withdraw',model)
        }
      checkMoney(model):Observable<any>{
          return this.http.post('localhost:4200/atm/checkMoney',model)
        }
      transfer(model):Observable<any>{
          return this.http.post('localhost:4200/atm/transfer',model)
        }

}
//สร้าง Model มาลองรับหรือส่ง ข้อมูลจากหลังบ้าน
export class ATM{
   user_id?:Number ;
   user_name?:String ;
	 user_pass?:String ;
	 user_money?:String ;
}
export class ModelOrder{
  id?:Number;
  code?:String;
  nameOrder?:String;
  price?:Number;
  qty?:Number;
  amount?:Number;
}
export class Model{
  a?:String;
  b?:String;
  opera?:String;
  result?:String;
}
export class ModelInfo{
  lname:String;
  name : String;
  nonumber:String;
}

