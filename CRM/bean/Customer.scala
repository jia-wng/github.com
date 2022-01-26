package MyProject.CRM.bean


class Customer {
  //1. create Customer Properties,
  var Id:Int =_
  var Name:String = _
  var Gender:String =_
  var Age:Short = _
  var Tel:String = _
  var Email:String = _

  //2. create constructor
  def this(Id:Int,Name:String,Gender:String,Age:Short,Tel:String,Email:String){
    this
    this.Id = Id
    this.Name = Name
    this.Gender = Gender
    this.Age = Age
    this.Tel = Tel
    this.Email = Email
  }

  def this(Name:String,Gender:String,Age:Short,Tel:String,Email:String){
    this
    this.Name = Name
    this.Gender = Gender
    this.Age = Age
    this.Tel = Tel
    this.Email = Email
  }


 //override toString method
  override def toString: String = {
    this.Id + "\t\t" + this.Name+ "\t\t\t" + this.Gender + "\t\t" + this.Age+ "\t\t" +
      this.Tel+ "\t\t" + this.Email
  }



}

