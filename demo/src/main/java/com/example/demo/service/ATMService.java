package com.example.demo.service;

import com.example.demo.atmentity.ATM;
import com.example.demo.reposite.ATMRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ATMService {
    @Autowired
    private ATMRepo repo;
    public boolean validPass(String user_pass,String user_name) {
        if(repo.findByUser_nameAndAndUser_pass(user_pass,user_name)!=null) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deposit(ATM model) {
        double sum;
        if(Double.parseDouble(model.getUser_money())%100.00==0) {
            System.out.print(model.getUser_money()+" pass "+model.getUser_pass());
            ATM bean=repo.findByUser_pass(model.getUser_pass());
            sum=Double.parseDouble(model.getUser_money())+Double.parseDouble(bean.getUser_money());
            bean.setUser_money(String.valueOf(sum));
            repo.save(bean);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean withdraw(ATM model) {
        double sum;
        if(Double.parseDouble(model.getUser_money())%100.00==0) {
            ATM bean=repo.findByUser_pass(model.getUser_pass());
            if(Double.parseDouble(model.getUser_money())<=Double.parseDouble(bean.getUser_money())){
                sum=Double.parseDouble(bean.getUser_money())-Double.parseDouble(model.getUser_money());
                bean.setUser_money(String.valueOf(sum));
                repo.save(bean);
                return true;
            }
            else {
                return false;
            }

        }
        else {
            return false;
        }
    }
    public ATM checkMoney(String user_pass) {
        return repo.findByUser_pass(user_pass);
    }
    public boolean transfer(ATM model) {
        double sum;
        //BeanTran คือคนที่ได้รับเงิน || bean คือผู้โอน
        ATM beanTran=repo.findByUser_name(model.getUser_name());
        System.out.println(model.getUser_pass());
        ATM bean=repo.findByUser_pass(model.getUser_pass());
        System.out.println("bean :"+bean.getUser_money());
        if(beanTran.getUser_name()!=null && Double.parseDouble(model.getUser_money())<=1000000.00) {
            sum = Double.parseDouble(beanTran.getUser_money())+Double.parseDouble(model.getUser_money());
            beanTran.setUser_money(String.valueOf(sum));
            sum = Double.parseDouble(bean.getUser_money())-Double.parseDouble(model.getUser_money());
            bean.setUser_money(String.valueOf(sum));
            repo.save(bean);
            repo.save(beanTran);
            return true;
        }
        else {
            return false;
        }

    }
}
