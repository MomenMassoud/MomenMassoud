<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="userPage.aspx.cs" Inherits="WebApplication1.userPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>BMR_Moives</title>
    <link rel="shortcut icon"  href="IMAGE/BMR.jpg">
    <style>
        .images {
            display: flex;
            flex-wrap: wrap;
            margin: 0 50px;
            padding: 30px;
        }
  
        .photo {
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
        }
        .photoname {
            color:red;
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
        }
  
        .photo img {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
             <h1 style="height: 88px; background-color: #CCCCCC; text-align: center;">BMR_Movies
                 <input type="search" />
                <asp:Button ID="Button3" runat="server" Text="Home" Width="157px" PostBackUrl="~/Home.aspx" />
                <img  src="Images/user.jpeg" width="70px" padding="10px"/>
            </h1>
        </div>
         <fieldset>
             <label>Name:####################</label>
             <br /><br />
             <label>Email:###################</label>
             <br /><br />
             <label>Enter Current Password:</label>
             <input type="password" name="cpass"/>
             <br /><br />
             <label>New Password:</label>
             <input type="password" name="npass"/>
             <br /><br />
             <label>Confirm Your Password:</label>
             <input type="password" name="conpass"/>
             <br /><br />
             <input type="submit" />
             <input type="reset"/>
         </fieldset>


        <fieldset>
             <label>The Movies You Like</label>
             <br /><br />
              <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>
                  </div>
         </fieldset>
    </form>
</body>
</html>
