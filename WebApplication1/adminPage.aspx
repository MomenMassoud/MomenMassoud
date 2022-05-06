<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="adminPage.aspx.cs" Inherits="WebApplication1.adminPage" %>

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
                <asp:Button ID="Button3" runat="server" Text="Home" Width="157px" PostBackUrl="~/Home.aspx" />
                <img  src="Images/admin.jpeg" width="70px" padding="10px"/>
            </h1>
        </div>
         <fieldset>
            <label>Name:###########################</label>
            <br /> <br />
            <label>Email:###########################</label>
            <br /> <br />
            <label>Current Password:</label>
             <asp:TextBox ID="TextBox1" runat="server" OnTextChanged="TextBox1_TextChanged" TextMode="Password"></asp:TextBox>
&nbsp;<br /><br />
            <label>New Password:</label>
            <input type="password" name="npass" placeholder="Enter Your New Password:"/>
            <br /><br />
             <label>Confirm Password:</label>
            <input type="password" name="conpass" placeholder="Confirm Password:"/>
            <br /><br />
             <input type="submit" />
             <input type="reset"/>
        </fieldset>
         <br /><br />
        <label style="font-size: x-large; font-style: inherit; font-weight: bold; color: #3366CC; text-align: center;">Uploud New Movies</label>
        <br /><br />
         <fieldset>
             <label>Name of Movie:</label>
             <input type="text" name="nMovie" placeholder="Enter Name Of Movie:"/>
             <br /><br />
             <label>Picture of Movie:</label>
             <asp:FileUpload ID="FileUpload1" runat="server" />
             <br /><br />
             <label>Uploud Movie:</label>
             <asp:FileUpload ID="FileUpload2" runat="server" />
             <input type="submit"/>
         </fieldset>
    </form>
</body>
</html>
