package shop.bean;

public class Book {
	String  order_number,
			bookname,
			author,
			publisher,
			category,
			logname,
			bookImg;      
int  booknumber,price;     //数量9
    public void setOrder_number(String order_num)
    {  order_number=order_num;
    }
   public String getOrder_number()
    {return order_number;
    }
   public void setBookImg(String img)
   {  bookImg=img;
   }
  public String getBookImg()
   {return bookImg;
   }
   public void setBookname(String book_na)
    {  bookname=book_na;
    }
   public String getBookname()
   {
	   return bookname;
   }
    public String getAuthor()
    {return author;
    }
   public void setAuthor(String pw)
    {  author=pw;
    }
    public String getPublisher()
    {return publisher;
    }
   public void setPublisher(String em)
    {  publisher=em;
    }
    public String getCategory()
    {return category;
    }
   public void setCategory(String ph)
    {  category=ph;
    }
   public String getLogname()
   {return logname;
   }
  public void setLogname(String ph)
   {  logname=ph;
   }
   public int getBooknumber()
    {return booknumber;
    }
   public void setBooknumber(int ad)
    {  booknumber=ad;
    }
   public int getPrice()
    {return price;
    }
   public void setPrice(int pri)
    {price=pri;
    } 

}
