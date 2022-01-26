package MyProject.CRM.service

import MyProject.CRM.bean.Customer

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn
import scala.util.control.Breaks.{break, breakable}

/*
1. Create a CustomerService
2. Complete the corresponding functions in this class
 */
class CustomerService {
  var customernum = 1
  val customers = ArrayBuffer(new Customer(1,"Tom","Male",
    10,"1526378903648","Tim@123.com")) // Initialize a data for testing purposes

  def list():ArrayBuffer[Customer] = {
    this.customers
  }

  //querying a customer info when we input Id or Name
  def queryInfo(index: Int): Unit ={
    if (index == 1){
      println("Please enter Id: ")
      val searchId = StdIn.readInt()
      for(item <- customers){
        if(searchId == item.Id){
          println("ID\t\tName\t\tGender\t\tAge\t\tTel\t\t\tE-mail")
          println(item)
        }
      }
    } else if(index == 2){
      println("Please enter name: ")
      val searchName = StdIn.readLine().toLowerCase
      for(item <- customers){
        if(item.Name.toLowerCase.equals(searchName) || item.Name.toLowerCase.contains(searchName)){
          println("ID\t\tName\t\tGender\t\tAge\t\tTel\t\t\tE-mail")
          println(item)
        }
      }
    } else{
      println("Can not find this customer information!")
    }

  }

  //Updating a customer info,Where name, Id, and gender are constant.

  def update(index:Int){
    if (index != -1){
      val customersArray = customers(index)
      println("Name" + "("+ customersArray.Name + ") ")
      println("Gender" + "("+ customersArray.Gender + ")")

      println("Age" + "("+ customersArray.Age + "): ")
      val age = StdIn.readShort()
      if(age != 0 ) {
        customersArray.Age = age
      }
      println("Tel" + "("+ customersArray.Tel + "): ")
      val tel = StdIn.readLine()
      if(tel != "" && tel != null){
        customersArray.Tel = tel
      }
      println("Email" + "("+ customersArray.Email + "): ")
      val email = StdIn.readLine()
      if (email != "" && email != null){
        customersArray.Email = email
      }
      customers.update(index,customersArray)
      println("Information modified successfully")

    }
  }

  /*
 1. Add a new customer
 id self-increment
  */
  def addNew(customer:Customer): Boolean ={
    //set id
    customernum += 1
    customer.Id = customernum
    customers.append(customer)
    true
  }

  //according to Id to find Index
  def findIndex(id:Int) = {
    var index = -1 // if not find then return -1
    breakable {
      for (i <- 0 until customers.length) {
        if (customers(i).Id == id) {
          index = i
          break()
        }
      }
    }
    index
  }
  def del(id:Int):Boolean = {
    val index = findIndex(id)
    if (index != -1){
      customers.remove(index)
      true
    }else{
      false
    }
  }
}


