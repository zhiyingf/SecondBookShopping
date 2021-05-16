package shop.bean;

public class OrderForm {
	String  logname,  //用户名
		    bookname, //书名
		    realname, //真实姓名
		    order_number,//图书订购号		    
		    phone,
		    address,
		    bookImg;        
       int  booknumber,price;     //数量9
       public void setBookImg(String img)
       {  bookImg=img;
       }
      public String getBookImg()
       {return bookImg;
       }
       public int getPrice()
       {return price;
       }
      public void setPrice(int pri)
       {price=pri;
       } 
       public void setLogname(String name)
       {  logname=name;
       }
      public String getLogname()
       {return logname;
       }
     public void setRealname(String name)
       {  realname=name;
       }
       public String getRealname()
       {return realname;
       }
     public void setOrder_number(String number)
       {  order_number=number;
       }
     public String getOrder_number()
       {return order_number;
       }
     public void setBookname(String name)
       {  bookname=name;
       }
     public String getBookname()
       {return bookname;
       }
     public void setPhone(String ph)
       {  phone=ph;
       }
      public String getPhone()
       {return phone;
       }
      public void setAddress(String ad)
       {  address=ad;
       }
      public String getAddress()
       {return address;
       }
      public void setBooknumber(int n)//7
       {  booknumber=n;
       }
      public int getBooknumber()
       {return booknumber;
       }
}
