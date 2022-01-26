package MyProject.CRM.view

import MyProject.CRM.bean.Customer
import MyProject.CRM.service.CustomerService

import scala.io.StdIn


/*
1. Create a CustomerView
2. Show the below information
---------------------Customer Information Management------------------------
                         1. Add a new customer
                         2. Modify customer
                         3. Delete a customer
                         4. Querying customer information
                         5. Show all customers
                         6. Exit System
                         Please choose a number (1 - 6):_
----------------------------------------------------------------------------
3.  Call the logic layer code to implement operations such as adding, deleting, modifying and querying
 */
class CustomerView {

  //Define a loop variable to control whether to exit the while loop
  var loop = true
  //Define a key to receive the user's options
  var key = ' '
  val customerservice = new CustomerService()
  def mainMenu():Unit ={
    do{
      println("----------------------Customer Information Management------------------------")
      println("                          1. Add a new customer")
      println("                          2. Modify customer")
      println("                          3. Delete a customer")
      println("                          4. Querying customer information")
      println("                          5. Show all customers")
      println("                          6. Exit System")
      println("                          Please choose a number (1 - 6):_")
      println("---------------------------------------------------------------------------")
      key = StdIn.readChar()
      key match {
        case '1' => this.add()
        case '2' => this.modify()
        case '3' => this.delete()
        case '4' => this.query()
        case '5' => this.showList()
        case '6' => this.exit()
        case _ => println("Please re-enter your options")
      }
    }while(loop)
    println("You have logged out of the system, welcome to log in next time!")
  }

  /*
  ----------------------Query Customer--------------------------------
  Please enter the customer id or name that you need to query
  Enter 1 to search by id, Enter 2 to search by name (-1 Exit ):
  1. id:
  2. name:


   */
  def query(): Unit ={
    println()
    println("----------------------Query Customer--------------------------------")

    println("Please enter the customer id or name that you need to query")
    println("Enter 1 to search by id, Enter 2 to search by name (-1 Exit ): ")
    val index= StdIn.readInt()
    if (index == -1){
      println("Query not completed")
      return
    }
    customerservice.queryInfo(index)
  }
  /*
  ----------------------Modify Customer--------------------------------
  Please select the customer number to be deleted (-1 Exit):
  name():
  gender():
  age():
  tel():
  email():
   */
  def modify(): Unit ={
    println()
    println("----------------------Modify Customer--------------------------------")
    println("Please select the customer number to be modified (-1 Exit): ")
    val id = StdIn.readInt()
    val index = customerservice.findIndex(id)

    if (index == -1){
      println("Modify not completed")
      return
    }
    customerservice.update(index)

  }
  //exit the customerview
  def exit(): Unit ={
    println("Please confirm to exit(Y/N):")
    val confirm = StdIn.readChar().toLower
    if(confirm == 'y') {
      this.loop = false
    }
  }

  /*
----------------------Delete Customer--------------------------------
Please select the customer number to be deleted (-1 Exit):
Confirmation of deletion(Y/N):

 */
  def delete(): Unit ={
    println()
    println("----------------------Delete Customer--------------------------------")
    println("Please select the customer number to be deleted (-1 Exit): ")
    val id = StdIn.readInt()
    if (id == -1){
      println("Delete not completed")
      return
    }

    println("Confirmation of deletion(Y/N):")
    val choice = StdIn.readChar().toLower
    if(choice == 'y'){
      if(customerservice.del(id)){
        println("Deleted successfully!")
        return
      }
    }
    println("Delete not completed")
  }
  /*
  ----------------------Add a New Customer--------------------------------
  Name:
  Gender:
  Age:
  Tel:
  E-mail:
  ------------------------------------------------------------------------
   */
  def add(): Unit ={
    println()
    println("----------------------Add a New Customer--------------------------------")
    println("Name: ")
    val name = StdIn.readLine()
    println("Gender: ")
    val gender = StdIn.readLine()
    println("Age: ")
    val age = StdIn.readShort()
    println("Tel: ")
    val tel = StdIn.readLine()
    println("E-mail: ")
    val email = StdIn.readLine()

    //create a obj
    val customer = new Customer(name,gender,age,tel,email)
    customerservice.addNew(customer)
    println("New customer added successfully!")
  }

  /*
  5. Show all customers
  ----------------------Customer List--------------------------------

  -------------------------------------------------------------------
   */
  def showList(): Unit ={
    println()
    println("----------------------Customer List--------------------------------")
    println("ID\t\tName\t\tGender\t\tAge\t\tTel\t\t\tE-mail")
    //for loop,to get customers ArrayBuffer
    val customers = customerservice.list()
    for (cus <- customers){
      println(cus)
    }
    println(" -------------------------------------------------------------------")
  }

}
