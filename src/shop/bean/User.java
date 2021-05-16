package shop.bean;

public class User {
	String  logname,
		    realname,
		    password,
		    email,
		    phone,
		    address;//7个
	public void setLogname(String name)//1
    {  logname=name;
    }
   public String getLogname()
    {return logname;
    }
   public void setRealname(String name)//2
    {  realname=name;
    }
    public String getRealname()
    {return realname;
    }
   public void setPassword(String pw)//3
    {  password=pw;
    }
    public String getPassword()
    {return password;
    }
   public void setEmail(String em)//4
    {  email=em;
    }
    public String getEmail()
    {return email;
    }
   public void setPhone(String ph)//5
    {  phone=ph;
    }
   public String getPhone()
    {return phone;
    }
   public void setAddress(String ad)//6
    {  address=ad;
    }
   public String getAddress()//7
    {return address;
    }

}
