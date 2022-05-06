<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="LoginAdmin.aspx.cs" Inherits="WebApplication1.LoginAdmin" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>BMR_Moives</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
             <h1 style="height: 88px; background-color: #CCCCCC; text-align: center;">BMR_Movies
                <input type="search" />
                <asp:Button ID="Button1" runat="server" Text="Subscribe For Free" Width="141px" PostBackUrl="~/signup.aspx" />
                <asp:Button ID="Button2" runat="server" Text="Login" Width="157px" PostBackUrl="~/Login.aspx" />
                 <asp:Button ID="Button3" runat="server" Text="Home" Width="157px" PostBackUrl="~/Home.aspx" />
            </h1>
        </div>
        <fieldset>
            <label>Email:</label>
            <input type="text" name="email" placeholder="Enter Your Email:" required/>
            <br /> <br />
            <label>Password:</label>
            <input type="password" name="pass" placeholder="Enter Your Password:" required/>
            <br /><br />
            <input type="submit"/>
            <input type="reset"/>
        </fieldset>
    </form>
</body>
</html>
