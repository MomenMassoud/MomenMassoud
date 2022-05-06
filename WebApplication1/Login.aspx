<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="WebApplication1.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>BMR_Moives</title>
    <link rel="shortcut icon"  href="IMAGE/BMR.jpg"/>
    <link rel="apple-touch-startup-image"  href="IMAGE/BMR.jpg"/>
</head>
<body>
    <form id="form1" runat="server">
       <div><!--Title-->
            <h1 style="height: 88px; background-color: #CCCCCC; text-align: center;">BMR_Movies
                <input type="search" />
                <asp:Button ID="Button1" runat="server" Text="Subscribe For Free" Width="141px" PostBackUrl="~/signup.aspx" />
                <asp:Button ID="Button2" runat="server" Text="Login" Width="157px" PostBackUrl="~/Login.aspx" />
                <asp:Button ID="Button3" runat="server" Text="Home" Width="157px" PostBackUrl="~/Home.aspx" />
                <a href="userPage.aspx"><img  src="Images/user.jpeg" width="70px" padding="10px"/></a>
            </h1>
    </div>
         <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Login User</p>
        <div class="form">
             <label>Email:</label>
            <input type="text" name="email" placeholder="Enter Your Email:" required/>
            <br /><br />
             <label>Password:</label>
            <input type="password" name="email" placeholder="Enter Your Password:" required/>
            <br /><br />
            <input type="submit"/>
            <input type="reset"/>
        </div>
    </form>
</body>
</html>
